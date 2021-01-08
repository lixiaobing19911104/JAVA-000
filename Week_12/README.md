第一章【3主3从redis集群配置】

1 开启docker后台服务

2 自己本地要有redis:6.0.8 镜像，docker images命令能够查看到

3 新建6个docker容器实例
docker create --name redis-node-1 --net host --privileged=true -v /data/redis/share/redis-node-1:/data redis:6.0.8 --cluster-enabled yes --appendonly yes --port 6381
 
docker create --name redis-node-2 --net host --privileged=true -v /data/redis/share/redis-node-2:/data redis:6.0.8 --cluster-enabled yes --appendonly yes --port 6382
 
docker create --name redis-node-3 --net host --privileged=true -v /data/redis/share/redis-node-3:/data redis:6.0.8 --cluster-enabled yes --appendonly yes --port 6383
 
docker create --name redis-node-4 --net host --privileged=true -v /data/redis/share/redis-node-4:/data redis:6.0.8 --cluster-enabled yes --appendonly yes --port 6384
 
docker create --name redis-node-5 --net host --privileged=true -v /data/redis/share/redis-node-5:/data redis:6.0.8 --cluster-enabled yes --appendonly yes --port 6385
 
docker create --name redis-node-6 --net host --privileged=true -v /data/redis/share/redis-node-6:/data redis:6.0.8 --cluster-enabled yes --appendonly yes --port 6386

4 docker ps -a查看结构，应该有6个容器实例，就是OK


5 成功启动上一步新建的6个docker容器实例
 docker start redis-node-1 redis-node-2 redis-node-3 redis-node-4 redis-node-5 redis-node-6


6 进入容器redis-node-1并为6台机器构建集群关系,1号机器类似药引子，可以通过它进入集群
docker exec -it redis-node-1 /bin/bash

7 构建1主1从的关系
redis-cli --cluster create \
192.168.111.147:6381 192.168.111.147:6382 192.168.111.147:6383 \
192.168.111.147:6384 192.168.111.147:6385 192.168.111.147:6386 \
--cluster-replicas 1 


8 链接进入6381作为切入点，查看节点状态
  redis-cli -p 6381
  cluster nodes



第二章【主从容错redis集群配置】

1 启动6机构成的集群并通过exec进入
  docker exec -it redis-node-1 /bin/bash


2 查看集群状态
redis-cli --cluster check 192.168.111.147:6381

3 防止路由失效加参数-c并新增两个key，演示加不加参数c的效果

  error

  right


4 主6381从6385切换，先停止主机6381
  docker stop redis-node-1

  可以看到6385，上位了。

  后续请验证数据+恢复即可。


第三章【主从容错redis集群配置】

1 查看状态
  redis-cli --cluster check 192.168.111.147:6381

2 先还原之前的3主3从
  docker stop redis-node-5
docker start redis-node-1
docker start redis-node-5

3 新建6387、6388两个节点+新建后启动+查看是否8节点
  docker create --name redis-node-7 --net host --privileged=true -v /data/redis/share/redis-node-7:/data redis:6.0.8 --cluster-enabled yes --appendonly yes --port 6387
docker create --name redis-node-8 --net host --privileged=true -v /data/redis/share/redis-node-8:/data redis:6.0.8 --cluster-enabled yes --appendonly yes --port 6388

docker start redis-node-7 redis-node-8

docker ps


4 进入6387容器实例内部
  docker exec -it redis-node-7 /bin/bash


5 将新增的6387节点(空槽号)作为master节点加入原集群

 将新增的6387作为master节点加入集群
redis-cli --cluster add-node 192.168.111.147:6387 192.168.111.147:6381
6387 就是将要作为master新增节点
6381  就是原来集群节点里面的领路人，相当于6387拜拜6381的码头从而找到组织加入集群


6 重新分派槽号
 
 命令:redis-cli --cluster reshard IP地址:端口号
redis-cli --cluster reshard 192.168.111.147:6381

7 检查集群节点
  redis-cli --cluster check 192.168.111.147:6381

8  为主节点6387分配从节点6388

 命令：redis-cli --cluster add-node ip:新slave端口 ip:新master端口 --cluster-slave --cluster-master-id 新主机节点ID
 
redis-cli --cluster add-node 192.168.111.147:6388 192.168.111.147:6387 --cluster-slave --cluster-master-id e4781f644d4a4e4d4b4d107157b9ba8144631451


9 redis-cli --cluster check 192.168.111.147:6382
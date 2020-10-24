### G1 4g
```
wrk -t 16 -c 200 -d60s http://localhost:8088/api/hello

Running 1m test @ http://localhost:8088/api/hello
  16 threads and 200 connections
  Thread Stats Avg Stdev Max +/- Stdev
    Latency 28.98ms 96.43ms 1.25s 96.82%
    Req/Sec 1.34k 413.74 3.34k 70.59%
  1239002 requests in 1.00m, 147.92MB read
  Socket errors: connect 0, read 51, write 0, timeout 0
Requests/sec: 20617.83
Transfer/sec: 2.46MB
```

### G1 2g
```
wrk -t 16 -c 200 -d60s http://localhost:8088/api/hello

Running 1m test @ http://localhost:8088/api/hello
  16 threads and 200 connections
  Thread Stats Avg Stdev Max +/- Stdev
    Latency 50.29ms 100.74ms 1.48s 90.92%
    Req/Sec 685.89 385.32 2.88k 59.71%
  647521 requests in 1.00m, 77.31MB read
  Socket errors: connect 0, read 80, write 0, timeout 0
Requests/sec: 10774.10
Transfer/sec: 1.29MB
```



### G1 1g
```
wrk -t 16 -c 200 -d60s http://localhost:8088/api/hello

Running 1m test @ http://localhost:8088/api/hello
  16 threads and 200 connections
  Thread Stats Avg Stdev Max +/- Stdev
    Latency 50.29ms 100.74ms 1.48s 90.92%
    Req/Sec 685.89 385.32 2.88k 59.71%
  647521 requests in 1.00m, 77.31MB read
  Socket errors: connect 0, read 80, write 0, timeout 0
Requests/sec: 10774.10
Transfer/sec: 1.29MB
```
### G1 512M
```
wrk -t 16 -c 200 -d60s http://localhost:8088/api/hello

Running 1m test @ http://localhost:8088/api/hello
  16 threads and 200 connections
  Thread Stats Avg Stdev Max +/- Stdev
    Latency 68.25ms 124.06ms 1.43s 89.37%
    Req/Sec 487.80 324.32 1.95k 59.98%
  457694 requests in 1.00m, 54.64MB read
  Socket errors: connect 0, read 128, write 10, timeout 0
Requests/sec: 7615.26
Transfer/sec: 0.91MB
```
### CMS 4g
```
wrk -t 16 -c 200 -d60s http://localhost:8088/api/hello

Running 1m test @ http://localhost:8088/api/hello
  16 threads and 200 connections
  Thread Stats Avg Stdev Max +/- Stdev
    Latency 45.24ms 88.44ms 1.01s 90.71%
    Req/Sec 728.45 418.41 2.22k 59.10%
  687836 requests in 1.00m, 82.12MB read
  Socket errors: connect 0, read 213, write 0, timeout 0
Requests/sec: 11442.21
Transfer/sec: 1.37MB
```
### CMS2g
```
wrk -t 16 -c 200 -d60s http://localhost:8088/api/hello

Running 1m test @ http://localhost:8088/api/hello
  16 threads and 200 connections
  Thread Stats Avg Stdev Max +/- Stdev
    Latency 72.94ms 134.90ms 1.66s 88.55%
    Req/Sec 566.71 387.15 2.11k 57.03%
  524551 requests in 1.00m, 62.62MB read
  Socket errors: connect 0, read 1, write 0, timeout 0
Requests/sec: 8728.16
Transfer/sec: 1.04MB
```

### CMS1g
```
wrk -t 16 -c 200 -d60s http://localhost:8088/api/hello

Running 1m test @ http://localhost:8088/api/hello
  16 threads and 200 connections
  Thread Stats Avg Stdev Max +/- Stdev
    Latency 54.78ms 111.79ms 1.29s 90.65%
    Req/Sec 660.09 379.58 2.29k 57.77%
  619924 requests in 1.00m, 74.01MB read
  Socket errors: connect 0, read 194, write 0, timeout 0
Requests/sec: 10318.84
Transfer/sec: 1.23MB
```

###CMS512m
```
wrk -t 16 -c 200 -d60s http://localhost:8088/api/hello

Running 1m test @ http://localhost:8088/api/hello
  16 threads and 200 connections
  Thread Stats Avg Stdev Max +/- Stdev
    Latency 49.57ms 103.21ms 1.31s 91.21%
    Req/Sec 686.09 363.55 4.48k 61.58%
  646933 requests in 1.00m, 77.24MB read
  Socket errors: connect 0, read 175, write 0, timeout 0
Requests/sec: 10767.33
Transfer/sec: 1.29MB
```

###parallel4g
```
wrk -t 16 -c 200 -d60s http://localhost:8088/api/hello

Running 1m test @ http://localhost:8088/api/hello
  16 threads and 200 connections
  Thread Stats Avg Stdev Max +/- Stdev
    Latency 53.50ms 104.47ms 1.31s 90.21%
    Req/Sec 665.34 398.67 1.91k 57.43%
  626974 requests in 1.00m, 74.85MB read
  Socket errors: connect 0, read 165, write 10, timeout 0
Requests/sec: 10431.40
Transfer/sec: 1.25MB
```
###parallel2g
```
wrk -t 16 -c 200 -d60s http://localhost:8088/api/hello

Running 1m test @ http://localhost:8088/api/hello
  16 threads and 200 connections
  Thread Stats Avg Stdev Max +/- Stdev
    Latency 18.84ms 29.14ms 283.75ms 88.41%
    Req/Sec 1.28k 448.37 3.35k 68.64%
  1211121 requests in 1.00m, 144.59MB read
Requests/sec: 20151.19
Transfer/sec: 2.41MB
```
###parallel1g
```
wrk -t 16 -c 200 -d60s http://localhost:8088/api/hello

Running 1m test @ http://localhost:8088/api/hello
  16 threads and 200 connections
  Thread Stats Avg Stdev Max +/- Stdev
    Latency 16.54ms 25.18ms 275.85ms 89.30%
    Req/Sec 1.32k 416.41 2.91k 67.71%
  1237409 requests in 1.00m, 147.73MB read
Requests/sec: 20587.23
Transfer/sec: 2.46MB
```
###parallel 512
```
wrk -t 16 -c 200 -d60s http://localhost:8088/api/hello

Running 1m test @ http://localhost:8088/api/hello
  16 threads and 200 connections
  Thread Stats Avg Stdev Max +/- Stdev
    Latency 64.24ms 123.37ms 1.24s 89.01%
    Req/Sec 646.13 419.73 2.78k 54.20%
  602983 requests in 1.00m, 71.99MB read
  Socket errors: connect 0, read 222, write 2, timeout 0
Requests/sec: 10033.52
Transfer/sec: 1.20MB
```

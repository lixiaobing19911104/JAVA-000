###并行GC
```
#128M
java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx128m -Xms128m -XX:+UseParallelGC GCLogAnalysis
#512M
java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx128m -Xms128m -XX:+UseSerialGC GCLogAnalysis
#1024M
java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx128m -Xms128m -XX:+UseSerialGC GCLogAnalysis
#2048M
java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx128m -Xms128m -XX:+UseSerialGC GCLogAnalysis
#4096M
java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx128m -Xms128m -XX:+UseSerialGC GCLogAnalysis```
```
###128M
```
#Parallel相对serial好太多了 
#年轻代叫PSYoungGen
#老年代ParOldGen
#minor 几毫秒
#major 十几毫秒
java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx128m -Xms128m -XX:+UseParallelGC GCLogAnalysis
正在执行...
2020-10-23T21:20:46.588-0800: [GC (Allocation Failure) [PSYoungGen: 33073K->5118K(38400K)] 33073K->11411K(125952K), 0.0044987 secs] [Times: user=0.01 sys=0.01, real=0.01 secs]
2020-10-23T21:20:46.606-0800: [GC (Allocation Failure) [PSYoungGen: 38398K->5117K(38400K)] 44691K->24990K(125952K), 0.0075396 secs] [Times: user=0.02 sys=0.01, real=0.01 secs]
2020-10-23T21:20:46.625-0800: [GC (Allocation Failure) [PSYoungGen: 38015K->5106K(38400K)] 57888K->36559K(125952K), 0.0064191 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-23T21:20:46.643-0800: [GC (Allocation Failure) [PSYoungGen: 37977K->5115K(38400K)] 69430K->48267K(125952K), 0.0056073 secs] [Times: user=0.00 sys=0.01, real=0.00 secs]
2020-10-23T21:20:46.657-0800: [GC (Allocation Failure) [PSYoungGen: 38395K->5112K(38400K)] 81547K->58739K(125952K), 0.0048431 secs] [Times: user=0.01 sys=0.01, real=0.01 secs]
2020-10-23T21:20:46.670-0800: [GC (Allocation Failure) [PSYoungGen: 38216K->5097K(19968K)] 91843K->71267K(107520K), 0.0055061 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-23T21:20:46.678-0800: [GC (Allocation Failure) [PSYoungGen: 19945K->11893K(29184K)] 86115K->78716K(116736K), 0.0028474 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2020-10-23T21:20:46.687-0800: [GC (Allocation Failure) [PSYoungGen: 26395K->14195K(29184K)] 93218K->83656K(116736K), 0.0050203 secs] [Times: user=0.01 sys=0.01, real=0.01 secs]
2020-10-23T21:20:46.694-0800: [GC (Allocation Failure) [PSYoungGen: 28472K->14264K(29184K)] 97933K->89294K(116736K), 0.0030288 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:20:46.697-0800: [Full GC (Ergonomics) [PSYoungGen: 14264K->0K(29184K)] [ParOldGen: 75030K->82647K(87552K)] 89294K->82647K(116736K), [Metaspace: 2706K->2706K(1056768K)], 0.0134367 secs] [Times: user=0.03 sys=0.01, real=0.02 secs]
2020-10-23T21:20:46.712-0800: [Full GC (Ergonomics) [PSYoungGen: 14733K->867K(29184K)] [ParOldGen: 82647K->87223K(87552K)] 97380K->88090K(116736K), [Metaspace: 2706K->2706K(1056768K)], 0.0159752 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
2020-10-23T21:20:46.731-0800: [Full GC (Ergonomics) [PSYoungGen: 14292K->5424K(29184K)] [ParOldGen: 87223K->87425K(87552K)] 101516K->92850K(116736K), [Metaspace: 2706K->2706K(1056768K)], 0.0123774 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
2020-10-23T21:20:46.744-0800: [Full GC (Ergonomics) [PSYoungGen: 14771K->10474K(29184K)] [ParOldGen: 87425K->87177K(87552K)] 102196K->97651K(116736K), [Metaspace: 2706K->2706K(1056768K)], 0.0140871 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
2020-10-23T21:20:46.759-0800: [Full GC (Ergonomics) [PSYoungGen: 14436K->11618K(29184K)] [ParOldGen: 87177K->86618K(87552K)] 101613K->98237K(116736K), [Metaspace: 2706K->2706K(1056768K)], 0.0024346 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2020-10-23T21:20:46.762-0800: [Full GC (Ergonomics) [PSYoungGen: 14798K->13546K(29184K)] [ParOldGen: 86618K->86567K(87552K)] 101417K->100114K(116736K), [Metaspace: 2706K->2706K(1056768K)], 0.0125947 secs] [Times: user=0.04 sys=0.00, real=0.01 secs]
2020-10-23T21:20:46.775-0800: [Full GC (Ergonomics) [PSYoungGen: 14824K->13823K(29184K)] [ParOldGen: 86567K->86552K(87552K)] 101392K->100376K(116736K), [Metaspace: 2706K->2706K(1056768K)], 0.0051176 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-23T21:20:46.780-0800: [Full GC (Ergonomics) [PSYoungGen: 14550K->13999K(29184K)] [ParOldGen: 86552K->86552K(87552K)] 101103K->100552K(116736K), [Metaspace: 2706K->2706K(1056768K)], 0.0060010 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-23T21:20:46.787-0800: [Full GC (Ergonomics) [PSYoungGen: 14841K->13219K(29184K)] [ParOldGen: 86552K->87516K(87552K)] 101393K->100736K(116736K), [Metaspace: 2706K->2706K(1056768K)], 0.0038728 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-23T21:20:46.791-0800: [Full GC (Ergonomics) [PSYoungGen: 14847K->12943K(29184K)] [ParOldGen: 87516K->87282K(87552K)] 102364K->100226K(116736K), [Metaspace: 2706K->2706K(1056768K)], 0.0092510 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2020-10-23T21:20:46.801-0800: [Full GC (Ergonomics) [PSYoungGen: 14824K->13260K(29184K)] [ParOldGen: 87282K->87113K(87552K)] 102106K->100374K(116736K), [Metaspace: 2706K->2706K(1056768K)], 0.0059413 secs] [Times: user=0.01 sys=0.01, real=0.00 secs]
2020-10-23T21:20:46.807-0800: [Full GC (Ergonomics) [PSYoungGen: 14780K->13517K(29184K)] [ParOldGen: 87113K->86858K(87552K)] 101894K->100376K(116736K), [Metaspace: 2706K->2706K(1056768K)], 0.0116049 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
2020-10-23T21:20:46.819-0800: [Full GC (Ergonomics) [PSYoungGen: 14727K->13711K(29184K)] [ParOldGen: 86858K->86858K(87552K)] 101586K->100570K(116736K), [Metaspace: 2706K->2706K(1056768K)], 0.0042600 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-23T21:20:46.824-0800: [Full GC (Ergonomics) [PSYoungGen: 14378K->13711K(29184K)] [ParOldGen: 86858K->86858K(87552K)] 101237K->100570K(116736K), [Metaspace: 2706K->2706K(1056768K)], 0.0016776 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:20:46.826-0800: [Full GC (Ergonomics) [PSYoungGen: 14749K->13612K(29184K)] [ParOldGen: 86858K->87159K(87552K)] 101608K->100772K(116736K), [Metaspace: 2706K->2706K(1056768K)], 0.0148333 secs] [Times: user=0.03 sys=0.00, real=0.02 secs]
2020-10-23T21:20:46.841-0800: [Full GC (Ergonomics) [PSYoungGen: 14225K->13696K(29184K)] [ParOldGen: 87159K->86837K(87552K)] 101385K->100534K(116736K), [Metaspace: 2706K->2706K(1056768K)], 0.0028056 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-23T21:20:46.844-0800: [Full GC (Ergonomics) [PSYoungGen: 14797K->14776K(29184K)] [ParOldGen: 86837K->86758K(87552K)] 101634K->101534K(116736K), [Metaspace: 2706K->2706K(1056768K)], 0.0135298 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-23T21:20:46.858-0800: [Full GC (Ergonomics) [PSYoungGen: 14848K->14776K(29184K)] [ParOldGen: 87454K->87197K(87552K)] 102302K->101973K(116736K), [Metaspace: 2706K->2706K(1056768K)], 0.0034025 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-23T21:20:46.862-0800: [Full GC (Ergonomics) [PSYoungGen: 14848K->14842K(29184K)] [ParOldGen: 87459K->87125K(87552K)] 102307K->101968K(116736K), [Metaspace: 2706K->2706K(1056768K)], 0.0053472 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:20:46.868-0800: [Full GC (Ergonomics) [PSYoungGen: 14848K->14842K(29184K)] [ParOldGen: 87546K->87066K(87552K)] 102394K->101909K(116736K), [Metaspace: 2706K->2706K(1056768K)], 0.0118097 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
2020-10-23T21:20:46.880-0800: [Full GC (Ergonomics) [PSYoungGen: 14842K->14842K(29184K)] [ParOldGen: 87345K->87205K(87552K)] 102188K->102048K(116736K), [Metaspace: 2706K->2706K(1056768K)], 0.0084473 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:20:46.889-0800: [Full GC (Ergonomics) [PSYoungGen: 14848K->14842K(29184K)] [ParOldGen: 87493K->87349K(87552K)] 102341K->102192K(116736K), [Metaspace: 2706K->2706K(1056768K)], 0.0028613 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-23T21:20:46.892-0800: [Full GC (Ergonomics) [PSYoungGen: 14842K->14842K(29184K)] [ParOldGen: 87549K->87061K(87552K)] 102392K->101904K(116736K), [Metaspace: 2706K->2706K(1056768K)], 0.0028807 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:20:46.895-0800: [Full GC (Allocation Failure) [PSYoungGen: 14842K->14842K(29184K)] [ParOldGen: 87061K->87042K(87552K)] 101904K->101885K(116736K), [Metaspace: 2706K->2706K(1056768K)], 0.0111207 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 at GCLogAnalysis.generateGarbage(GCLogAnalysis.java:47)
 at GCLogAnalysis.main(GCLogAnalysis.java:24)
Heap
 PSYoungGen total 29184K, used 14848K [0x00000007bd580000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 14848K, 100% used [0x00000007bd580000,0x00000007be400000,0x00000007be400000)
  from space 14336K, 0% used [0x00000007be400000,0x00000007be400000,0x00000007bf200000)
  to space 14336K, 0% used [0x00000007bf200000,0x00000007bf200000,0x00000007c0000000)
 ParOldGen total 87552K, used 87043K [0x00000007b8000000, 0x00000007bd580000, 0x00000007bd580000)
  object space 87552K, 99% used [0x00000007b8000000,0x00000007bd500d78,0x00000007bd580000)
 Metaspace used 2737K, capacity 4486K, committed 4864K, reserved 1056768K
  class space used 298K, capacity 386K, committed 512K, reserved 1048576K
```
512M
```
#PSYoungGen 需要10几毫秒
#ParOldGen需要四五十毫秒

java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx512m -Xms512m -XX:+UseParallelGC GCLogAnalysis
正在执行...
2020-10-23T21:24:21.100-0800: [GC (Allocation Failure) [PSYoungGen: 131584K->21501K(153088K)] 131584K->45433K(502784K), 0.0164726 secs] [Times: user=0.02 sys=0.03, real=0.01 secs]
2020-10-23T21:24:21.141-0800: [GC (Allocation Failure) [PSYoungGen: 152805K->21503K(153088K)] 176737K->85429K(502784K), 0.0246885 secs] [Times: user=0.02 sys=0.04, real=0.02 secs]
2020-10-23T21:24:21.188-0800: [GC (Allocation Failure) [PSYoungGen: 153000K->21497K(153088K)] 216926K->127392K(502784K), 0.0227056 secs] [Times: user=0.03 sys=0.02, real=0.03 secs]
2020-10-23T21:24:21.235-0800: [GC (Allocation Failure) [PSYoungGen: 153081K->21499K(153088K)] 258976K->171269K(502784K), 0.0308336 secs] [Times: user=0.03 sys=0.02, real=0.03 secs]
2020-10-23T21:24:21.297-0800: [GC (Allocation Failure) [PSYoungGen: 153083K->21499K(153088K)] 302853K->211633K(502784K), 0.0255939 secs] [Times: user=0.02 sys=0.03, real=0.03 secs]
2020-10-23T21:24:21.347-0800: [GC (Allocation Failure) [PSYoungGen: 153083K->21480K(80384K)] 343217K->250237K(430080K), 0.0185410 secs] [Times: user=0.02 sys=0.02, real=0.02 secs]
2020-10-23T21:24:21.373-0800: [GC (Allocation Failure) [PSYoungGen: 80360K->36505K(116736K)] 309117K->268722K(466432K), 0.0109399 secs] [Times: user=0.01 sys=0.01, real=0.01 secs]
2020-10-23T21:24:21.397-0800: [GC (Allocation Failure) [PSYoungGen: 95385K->47850K(116736K)] 327602K->286961K(466432K), 0.0085933 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2020-10-23T21:24:21.416-0800: [GC (Allocation Failure) [PSYoungGen: 106730K->53426K(116736K)] 345841K->300400K(466432K), 0.0138375 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
2020-10-23T21:24:21.438-0800: [GC (Allocation Failure) [PSYoungGen: 112306K->34412K(116736K)] 359280K->316745K(466432K), 0.0265011 secs] [Times: user=0.02 sys=0.02, real=0.03 secs]
2020-10-23T21:24:21.478-0800: [GC (Allocation Failure) [PSYoungGen: 92996K->18461K(116736K)] 375329K->334042K(466432K), 0.0176589 secs] [Times: user=0.02 sys=0.01, real=0.02 secs]
2020-10-23T21:24:21.496-0800: [Full GC (Ergonomics) [PSYoungGen: 18461K->0K(116736K)] [ParOldGen: 315581K->226138K(349696K)] 334042K->226138K(466432K), [Metaspace: 2706K->2706K(1056768K)], 0.0369361 secs] [Times: user=0.08 sys=0.01, real=0.04 secs]
2020-10-23T21:24:21.544-0800: [GC (Allocation Failure) [PSYoungGen: 58880K->17739K(116736K)] 285018K->243877K(466432K), 0.0034011 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-23T21:24:21.559-0800: [GC (Allocation Failure) [PSYoungGen: 76544K->21722K(116736K)] 302682K->264735K(466432K), 0.0071802 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2020-10-23T21:24:21.583-0800: [GC (Allocation Failure) [PSYoungGen: 80499K->23458K(116736K)] 323512K->287313K(466432K), 0.0089550 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-23T21:24:21.621-0800: [GC (Allocation Failure) [PSYoungGen: 82338K->18146K(116736K)] 346193K->303804K(466432K), 0.0258904 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
2020-10-23T21:24:21.671-0800: [GC (Allocation Failure) [PSYoungGen: 77026K->22170K(116736K)] 362684K->325477K(466432K), 0.0095157 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-23T21:24:21.680-0800: [Full GC (Ergonomics) [PSYoungGen: 22170K->0K(116736K)] [ParOldGen: 303306K->264830K(349696K)] 325477K->264830K(466432K), [Metaspace: 2706K->2706K(1056768K)], 0.0564780 secs] [Times: user=0.07 sys=0.01, real=0.05 secs]
2020-10-23T21:24:21.747-0800: [GC (Allocation Failure) [PSYoungGen: 58880K->16156K(116736K)] 323710K->280987K(466432K), 0.0049665 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-23T21:24:21.765-0800: [GC (Allocation Failure) [PSYoungGen: 74861K->18977K(116736K)] 339692K->299053K(466432K), 0.0081443 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2020-10-23T21:24:21.796-0800: [GC (Allocation Failure) [PSYoungGen: 77857K->16214K(116736K)] 357933K->314503K(466432K), 0.0058842 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-23T21:24:21.820-0800: [GC (Allocation Failure) [PSYoungGen: 74519K->18107K(116736K)] 372808K->330733K(466432K), 0.0068162 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-23T21:24:21.827-0800: [Full GC (Ergonomics) [PSYoungGen: 18107K->0K(116736K)] [ParOldGen: 312626K->275096K(349696K)] 330733K->275096K(466432K), [Metaspace: 2706K->2706K(1056768K)], 0.0443308 secs] [Times: user=0.06 sys=0.00, real=0.05 secs]
2020-10-23T21:24:21.879-0800: [GC (Allocation Failure) [PSYoungGen: 58880K->18545K(116736K)] 333976K->293641K(466432K), 0.0022776 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-23T21:24:21.890-0800: [GC (Allocation Failure) [PSYoungGen: 77424K->21889K(116736K)] 352521K->314593K(466432K), 0.0082612 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
2020-10-23T21:24:21.907-0800: [GC (Allocation Failure) [PSYoungGen: 80769K->22480K(116736K)] 373473K->335948K(466432K), 0.0077693 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-23T21:24:21.915-0800: [Full GC (Ergonomics) [PSYoungGen: 22480K->0K(116736K)] [ParOldGen: 313468K->290752K(349696K)] 335948K->290752K(466432K), [Metaspace: 2706K->2706K(1056768K)], 0.0399873 secs] [Times: user=0.09 sys=0.00, real=0.04 secs]
2020-10-23T21:24:21.966-0800: [GC (Allocation Failure) [PSYoungGen: 58647K->23985K(116736K)] 349399K->314737K(466432K), 0.0126614 secs] [Times: user=0.01 sys=0.01, real=0.01 secs]
2020-10-23T21:24:21.994-0800: [GC (Allocation Failure) [PSYoungGen: 82855K->21855K(116736K)] 373608K->334546K(466432K), 0.0061302 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2020-10-23T21:24:22.011-0800: [GC (Allocation Failure) [PSYoungGen: 80701K->19698K(116736K)] 393393K->352163K(466432K), 0.0109590 secs] [Times: user=0.01 sys=0.01, real=0.01 secs]
2020-10-23T21:24:22.022-0800: [Full GC (Ergonomics) [PSYoungGen: 19698K->0K(116736K)] [ParOldGen: 332465K->308655K(349696K)] 352163K->308655K(466432K), [Metaspace: 2706K->2706K(1056768K)], 0.0589948 secs] [Times: user=0.07 sys=0.00, real=0.06 secs]
执行结束!共生成对象次数:7433
Heap
 PSYoungGen total 116736K, used 2442K [0x00000007b5580000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 58880K, 4% used [0x00000007b5580000,0x00000007b57e2a78,0x00000007b8f00000)
  from space 57856K, 0% used [0x00000007bc780000,0x00000007bc780000,0x00000007c0000000)
  to space 57856K, 0% used [0x00000007b8f00000,0x00000007b8f00000,0x00000007bc780000)
 ParOldGen total 349696K, used 308655K [0x00000007a0000000, 0x00000007b5580000, 0x00000007b5580000)
  object space 349696K, 88% used [0x00000007a0000000,0x00000007b2d6bee0,0x00000007b5580000)
 Metaspace used 2713K, capacity 4486K, committed 4864K, reserved 1056768K
  class space used 295K, capacity 386K, committed 512K, reserved 1048576K
```
###1G
```
java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx1g -Xms1g -XX:+UseParallelGC GCLogAnalysis
#还是minnor20几ms，major50ms
#对象生成效率大幅增加
正在执行...
2020-10-23T21:39:22.768-0800: [GC (Allocation Failure) [PSYoungGen: 262144K->43515K(305664K)] 262144K->81456K(1005056K), 0.0274903 secs] [Times: user=0.03 sys=0.05, real=0.03 secs]
2020-10-23T21:39:22.842-0800: [GC (Allocation Failure) [PSYoungGen: 305659K->43515K(305664K)] 343600K->155565K(1005056K), 0.0396647 secs] [Times: user=0.04 sys=0.07, real=0.04 secs]
2020-10-23T21:39:22.923-0800: [GC (Allocation Failure) [PSYoungGen: 305659K->43519K(305664K)] 417709K->221319K(1005056K), 0.0305290 secs] [Times: user=0.04 sys=0.04, real=0.03 secs]
2020-10-23T21:39:22.998-0800: [GC (Allocation Failure) [PSYoungGen: 305663K->43513K(305664K)] 483463K->298992K(1005056K), 0.0423145 secs] [Times: user=0.06 sys=0.05, real=0.05 secs]
2020-10-23T21:39:23.078-0800: [GC (Allocation Failure) [PSYoungGen: 305657K->43519K(305664K)] 561136K->375290K(1005056K), 0.0335362 secs] [Times: user=0.04 sys=0.04, real=0.04 secs]
2020-10-23T21:39:23.154-0800: [GC (Allocation Failure) [PSYoungGen: 305663K->43506K(160256K)] 637434K->456971K(859648K), 0.0359283 secs] [Times: user=0.05 sys=0.04, real=0.04 secs]
2020-10-23T21:39:23.207-0800: [GC (Allocation Failure) [PSYoungGen: 160242K->70802K(232960K)] 573707K->491525K(932352K), 0.0121337 secs] [Times: user=0.03 sys=0.01, real=0.01 secs]
2020-10-23T21:39:23.240-0800: [GC (Allocation Failure) [PSYoungGen: 187538K->97085K(232960K)] 608261K->529262K(932352K), 0.0215684 secs] [Times: user=0.03 sys=0.00, real=0.02 secs]
2020-10-23T21:39:23.279-0800: [GC (Allocation Failure) [PSYoungGen: 213678K->107880K(232960K)] 645855K->557866K(932352K), 0.0230022 secs] [Times: user=0.04 sys=0.02, real=0.03 secs]
2020-10-23T21:39:23.321-0800: [GC (Allocation Failure) [PSYoungGen: 224616K->72080K(232960K)] 674602K->583639K(932352K), 0.0322346 secs] [Times: user=0.05 sys=0.04, real=0.03 secs]
2020-10-23T21:39:23.373-0800: [GC (Allocation Failure) [PSYoungGen: 188816K->39948K(232960K)] 700375K->616997K(932352K), 0.0332598 secs] [Times: user=0.04 sys=0.04, real=0.03 secs]
2020-10-23T21:39:23.424-0800: [GC (Allocation Failure) [PSYoungGen: 156684K->37989K(232960K)] 733733K->648946K(932352K), 0.0214465 secs] [Times: user=0.02 sys=0.02, real=0.02 secs]
2020-10-23T21:39:23.445-0800: [Full GC (Ergonomics) [PSYoungGen: 37989K->0K(232960K)] [ParOldGen: 610957K->341901K(699392K)] 648946K->341901K(932352K), [Metaspace: 2706K->2706K(1056768K)], 0.0558292 secs] [Times: user=0.13 sys=0.01, real=0.06 secs]
2020-10-23T21:39:23.516-0800: [GC (Allocation Failure) [PSYoungGen: 116736K->38431K(232960K)] 458637K->380333K(932352K), 0.0077713 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2020-10-23T21:39:23.541-0800: [GC (Allocation Failure) [PSYoungGen: 154763K->45020K(232960K)] 496665K->421517K(932352K), 0.0121433 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
2020-10-23T21:39:23.575-0800: [GC (Allocation Failure) [PSYoungGen: 161176K->44550K(232960K)] 537673K->459570K(932352K), 0.0153702 secs] [Times: user=0.03 sys=0.01, real=0.02 secs]
执行结束!共生成对象次数:10114
Heap
 PSYoungGen total 232960K, used 104393K [0x00000007aab00000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 116736K, 51% used [0x00000007aab00000,0x00000007ae570f10,0x00000007b1d00000)
  from space 116224K, 38% used [0x00000007b1d00000,0x00000007b48818c0,0x00000007b8e80000)
  to space 116224K, 0% used [0x00000007b8e80000,0x00000007b8e80000,0x00000007c0000000)
 ParOldGen total 699392K, used 415019K [0x0000000780000000, 0x00000007aab00000, 0x00000007aab00000)
  object space 699392K, 59% used [0x0000000780000000,0x000000079954afc0,0x00000007aab00000)
 Metaspace used 2713K, capacity 4486K, committed 4864K, reserved 1056768K
  class space used 295K, capacity 386K, committed 512K, reserved 1048576K
```
### 2G
```
java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx2g -Xms2g -XX:+UseParallelGC GCLogAnalysis
#只有minorGC，对象生成效率达到了12000
正在执行...
2020-10-23T21:41:55.732-0800: [GC (Allocation Failure) [PSYoungGen: 524800K->87026K(611840K)] 524800K->138470K(2010112K), 0.0498553 secs] [Times: user=0.05 sys=0.08, real=0.05 secs]
2020-10-23T21:41:55.867-0800: [GC (Allocation Failure) [PSYoungGen: 611826K->87031K(611840K)] 663270K->246599K(2010112K), 0.0678561 secs] [Times: user=0.07 sys=0.12, real=0.07 secs]
2020-10-23T21:41:56.004-0800: [GC (Allocation Failure) [PSYoungGen: 611831K->87028K(611840K)] 771399K->362935K(2010112K), 0.0501847 secs] [Times: user=0.08 sys=0.07, real=0.05 secs]
2020-10-23T21:41:56.130-0800: [GC (Allocation Failure) [PSYoungGen: 611828K->87034K(611840K)] 887735K->467213K(2010112K), 0.0471072 secs] [Times: user=0.07 sys=0.06, real=0.04 secs]
2020-10-23T21:41:56.245-0800: [GC (Allocation Failure) [PSYoungGen: 611834K->87030K(611840K)] 992013K->593790K(2010112K), 0.0554891 secs] [Times: user=0.08 sys=0.09, real=0.06 secs]
2020-10-23T21:41:56.365-0800: [GC (Allocation Failure) [PSYoungGen: 611830K->87032K(320000K)] 1118590K->716068K(1718272K), 0.0559776 secs] [Times: user=0.08 sys=0.09, real=0.06 secs]
执行结束!共生成对象次数:12501
Heap
 PSYoungGen total 320000K, used 229675K [0x0000000795580000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 232960K, 61% used [0x0000000795580000,0x000000079e0ccc28,0x00000007a3900000)
  from space 87040K, 99% used [0x00000007bab00000,0x00000007bfffe290,0x00000007c0000000)
  to space 232960K, 0% used [0x00000007a3900000,0x00000007a3900000,0x00000007b1c80000)
 ParOldGen total 1398272K, used 629036K [0x0000000740000000, 0x0000000795580000, 0x0000000795580000)
  object space 1398272K, 44% used [0x0000000740000000,0x000000076664b0f0,0x0000000795580000)
 Metaspace used 2713K, capacity 4486K, committed 4864K, reserved 1056768K
  class space used 295K, capacity 386K, committed 512K, reserved 1048576K
```

###4G
```
java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx4g -Xms4g -XX:+UseParallelGC GCLogAnalysis\
#只有MinorGC，GC次数减少，耗时增加到了100ms左右
正在执行...
2020-10-23T21:44:04.166-0800: [GC (Allocation Failure) [PSYoungGen: 1048576K->174590K(1223168K)] 1048576K->236715K(4019712K), 0.0788401 secs] [Times: user=0.08 sys=0.14, real=0.08 secs]
2020-10-23T21:44:04.409-0800: [GC (Allocation Failure) [PSYoungGen: 1223166K->174584K(1223168K)] 1285291K->364468K(4019712K), 0.1226838 secs] [Times: user=0.11 sys=0.19, real=0.13 secs]
执行结束!共生成对象次数:10233
Heap
 PSYoungGen total 1223168K, used 832711K [0x000000076ab00000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 1048576K, 62% used [0x000000076ab00000,0x0000000792db3e48,0x00000007aab00000)
  from space 174592K, 99% used [0x00000007b5580000,0x00000007bfffe100,0x00000007c0000000)
  to space 174592K, 0% used [0x00000007aab00000,0x00000007aab00000,0x00000007b5580000)
 ParOldGen total 2796544K, used 189884K [0x00000006c0000000, 0x000000076ab00000, 0x000000076ab00000)
  object space 2796544K, 6% used [0x00000006c0000000,0x00000006cb96f0e0,0x000000076ab00000)
 Metaspace used 2713K, capacity 4486K, committed 4864K, reserved 1056768K
  class space used 295K, capacity 386K, committed 512K, reserved 1048576K
```

###8G
```
java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx8g -Xms8g -XX:+UseParallelGC GCLogAnalysis
#8G不发生GC但是反而生产对象效率降低
正在执行...
执行结束!共生成对象次数:7069
Heap
 PSYoungGen total 2446848K, used 1983297K [0x0000000715580000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 2097664K, 94% used [0x0000000715580000,0x000000078e650408,0x0000000795600000)
  from space 349184K, 0% used [0x00000007aab00000,0x00000007aab00000,0x00000007c0000000)
  to space 349184K, 0% used [0x0000000795600000,0x0000000795600000,0x00000007aab00000)
 ParOldGen total 5592576K, used 0K [0x00000005c0000000, 0x0000000715580000, 0x0000000715580000)
  object space 5592576K, 0% used [0x00000005c0000000,0x00000005c0000000,0x0000000715580000)
 Metaspace used 2712K, capacity 4486K, committed 4864K, reserved 1056768K
  class space used 295K, capacity 386K, committed 512K, reserved 1048576K
```

#128M
```
#年轻代叫做parnew，#老年代叫做conc-mark-seep-generation
java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx128m -Xms128m -XX:+UseConcMarkSweepGC GCLogAnalysis

正在执行...
2020-10-23T21:50:34.746-0800: [GC (Allocation Failure) 2020-10-23T21:50:34.746-0800: [ParNew: 34684K->4336K(39296K), 0.0047219 secs] 34684K->11195K(126720K), 0.0047808 secs] [Times: user=0.01 sys=0.01, real=0.01 secs]
2020-10-23T21:50:34.760-0800: [GC (Allocation Failure) 2020-10-23T21:50:34.760-0800: [ParNew: 39084K->4352K(39296K), 0.0083310 secs] 45943K->22982K(126720K), 0.0083805 secs] [Times: user=0.01 sys=0.01, real=0.00 secs]
2020-10-23T21:50:34.777-0800: [GC (Allocation Failure) 2020-10-23T21:50:34.777-0800: [ParNew: 38952K->4338K(39296K), 0.0146455 secs] 57582K->35591K(126720K), 0.0147378 secs] [Times: user=0.02 sys=0.01, real=0.02 secs]
2020-10-23T21:50:34.799-0800: [GC (Allocation Failure) 2020-10-23T21:50:34.799-0800: [ParNew: 39282K->4345K(39296K), 0.0091360 secs] 70535K->47010K(126720K), 0.0092002 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2020-10-23T21:50:34.813-0800: [GC (Allocation Failure) 2020-10-23T21:50:34.814-0800: [ParNew: 39186K->4347K(39296K), 0.0100096 secs] 81851K->59781K(126720K), 0.0100708 secs] [Times: user=0.02 sys=0.01, real=0.01 secs]
#初始标记
2020-10-23T21:50:34.824-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 55433K(87424K)] 60370K(126720K), 0.0003625 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
#并发标记
2020-10-23T21:50:34.824-0800: [CMS-concurrent-mark-start]
2020-10-23T21:50:34.826-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
#并发预清理
2020-10-23T21:50:34.826-0800: [CMS-concurrent-preclean-start]
2020-10-23T21:50:34.827-0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
#可终止的并发预清理
2020-10-23T21:50:34.827-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-23T21:50:34.830-0800: [GC (Allocation Failure) 2020-10-23T21:50:34.830-0800: [ParNew: 39030K->4350K(39296K), 0.0085343 secs] 94464K->71848K(126720K), 0.0086158 secs] [Times: user=0.03 sys=0.00, real=0.00 secs]
2020-10-23T21:50:34.844-0800: [GC (Allocation Failure) 2020-10-23T21:50:34.844-0800: [ParNew: 39294K->4347K(39296K), 0.0075803 secs] 106792K->83481K(126720K), 0.0076238 secs] [Times: user=0.02 sys=0.01, real=0.01 secs]
2020-10-23T21:50:34.858-0800: [GC (Allocation Failure) 2020-10-23T21:50:34.858-0800: [ParNew: 39291K->39291K(39296K), 0.0000258 secs]2020-10-23T21:50:34.858-0800: [CMS2020-10-23T21:50:34.858-0800: [CMS-concurrent-abortable-preclean: 0.001/0.032 secs] [Times: user=0.06 sys=0.01, real=0.03 secs]
#并发模式失败
 (concurrent mode failure): 79134K->87273K(87424K), 0.0195771 secs] 118425K->89215K(126720K), [Metaspace: 2706K->2706K(1056768K)], 0.0196698 secs] [Times: user=0.01 sys=0.00, real=0.02 secs]
2020-10-23T21:50:34.884-0800: [Full GC (Allocation Failure) 2020-10-23T21:50:34.884-0800: [CMS: 87400K->87351K(87424K), 0.0154073 secs] 126694K->101000K(126720K), [Metaspace: 2706K->2706K(1056768K)], 0.0155160 secs] [Times: user=0.01 sys=0.00, real=0.02 secs]
2020-10-23T21:50:34.900-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 87351K(87424K)] 101715K(126720K), 0.0002799 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:50:34.901-0800: [CMS-concurrent-mark-start]
2020-10-23T21:50:34.901-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:50:34.902-0800: [CMS-concurrent-preclean-start]
2020-10-23T21:50:34.902-0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:50:34.902-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-23T21:50:34.902-0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
#最终标记
2020-10-23T21:50:34.902-0800: [GC (CMS Final Remark) [YG occupancy: 22744 K (39296 K)]2020-10-23T21:50:34.902-0800: [Rescan (parallel) , 0.0001499 secs]2020-10-23T21:50:34.902-0800: [weak refs processing, 0.0000186 secs]2020-10-23T21:50:34.902-0800: [class unloading, 0.0002450 secs]2020-10-23T21:50:34.903-0800: [scrub symbol table, 0.0003145 secs]2020-10-23T21:50:34.903-0800: [scrub string table, 0.0001638 secs][1 CMS-remark: 87351K(87424K)] 110096K(126720K), 0.0009697 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
#并发清理
2020-10-23T21:50:34.903-0800: [CMS-concurrent-sweep-start]
2020-10-23T21:50:34.904-0800: [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
#并发重置
2020-10-23T21:50:34.904-0800: [CMS-concurrent-reset-start]
2020-10-23T21:50:34.904-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:50:34.906-0800: [GC (Allocation Failure) 2020-10-23T21:50:34.906-0800: [ParNew: 39280K->39280K(39296K), 0.0000233 secs]2020-10-23T21:50:34.906-0800: [CMS: 87342K->87176K(87424K), 0.0118417 secs] 126623K->108239K(126720K), [Metaspace: 2706K->2706K(1056768K)], 0.0119251 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-23T21:50:34.918-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 87176K(87424K)] 108481K(126720K), 0.0001526 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:50:34.919-0800: [CMS-concurrent-mark-start]
2020-10-23T21:50:34.922-0800: [CMS-concurrent-mark: 0.003/0.003 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-23T21:50:34.922-0800: [CMS-concurrent-preclean-start]
2020-10-23T21:50:34.923-0800: [Full GC (Allocation Failure) 2020-10-23T21:50:34.923-0800: [CMS2020-10-23T21:50:34.924-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 (concurrent mode failure): 87176K->87269K(87424K), 0.0161459 secs] 126437K->111763K(126720K), [Metaspace: 2706K->2706K(1056768K)], 0.0162400 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-23T21:50:34.942-0800: [Full GC (Allocation Failure) 2020-10-23T21:50:34.942-0800: [CMS: 87341K->87158K(87424K), 0.0272276 secs] 126581K->115525K(126720K), [Metaspace: 2706K->2706K(1056768K)], 0.0272843 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
2020-10-23T21:50:34.969-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 87158K(87424K)] 115669K(126720K), 0.0002737 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2020-10-23T21:50:34.970-0800: [CMS-concurrent-mark-start]
2020-10-23T21:50:34.971-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:50:34.971-0800: [CMS-concurrent-preclean-start]
2020-10-23T21:50:34.972-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-23T21:50:34.972-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-23T21:50:34.972-0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:50:34.973-0800: [GC (CMS Final Remark) [YG occupancy: 38786 K (39296 K)]2020-10-23T21:50:34.973-0800: [Rescan (parallel) , 0.0012736 secs]2020-10-23T21:50:34.974-0800: [weak refs processing, 0.0000212 secs]2020-10-23T21:50:34.974-0800: [class unloading, 0.0002250 secs]2020-10-23T21:50:34.975-0800: [scrub symbol table, 0.0003019 secs]2020-10-23T21:50:34.975-0800: [scrub string table, 0.0001755 secs][1 CMS-remark: 87158K(87424K)] 125944K(126720K), 0.0020964 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:50:34.975-0800: [CMS-concurrent-sweep-start]
2020-10-23T21:50:34.975-0800: [Full GC (Allocation Failure) 2020-10-23T21:50:34.975-0800: [CMS2020-10-23T21:50:34.976-0800: [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 (concurrent mode failure): 87243K->87295K(87424K), 0.0176418 secs] 126487K->116276K(126720K), [Metaspace: 2706K->2706K(1056768K)], 0.0176925 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
2020-10-23T21:50:34.995-0800: [Full GC (Allocation Failure) 2020-10-23T21:50:34.995-0800: [CMS: 87295K->87306K(87424K), 0.0167294 secs] 126494K->118595K(126720K), [Metaspace: 2706K->2706K(1056768K)], 0.0167837 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
2020-10-23T21:50:35.012-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 87306K(87424K)] 118829K(126720K), 0.0001890 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:50:35.012-0800: [CMS-concurrent-mark-start]
2020-10-23T21:50:35.013-0800: [Full GC (Allocation Failure) 2020-10-23T21:50:35.013-0800: [CMS2020-10-23T21:50:35.014-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.01, real=0.00 secs]
 (concurrent mode failure): 87306K->87411K(87424K), 0.0154372 secs] 126336K->122453K(126720K), [Metaspace: 2706K->2706K(1056768K)], 0.0154836 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-23T21:50:35.030-0800: [Full GC (Allocation Failure) 2020-10-23T21:50:35.030-0800: [CMS: 87411K->87356K(87424K), 0.0149203 secs] 126637K->124562K(126720K), [Metaspace: 2706K->2706K(1056768K)], 0.0149774 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2020-10-23T21:50:35.045-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 87356K(87424K)] 124706K(126720K), 0.0001814 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:50:35.045-0800: [CMS-concurrent-mark-start]
2020-10-23T21:50:35.046-0800: [Full GC (Allocation Failure) 2020-10-23T21:50:35.046-0800: [CMS2020-10-23T21:50:35.046-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 (concurrent mode failure): 87356K->87356K(87424K), 0.0055158 secs] 126508K->125324K(126720K), [Metaspace: 2706K->2706K(1056768K)], 0.0055802 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2020-10-23T21:50:35.052-0800: [Full GC (Allocation Failure) 2020-10-23T21:50:35.052-0800: [CMS: 87356K->87262K(87424K), 0.0057941 secs] 126559K->125334K(126720K), [Metaspace: 2706K->2706K(1056768K)], 0.0058800 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-23T21:50:35.058-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 87262K(87424K)] 125548K(126720K), 0.0003904 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:50:35.059-0800: [CMS-concurrent-mark-start]
2020-10-23T21:50:35.059-0800: [Full GC (Allocation Failure) 2020-10-23T21:50:35.059-0800: [CMS2020-10-23T21:50:35.060-0800: [CMS-concurrent-mark: 0.001/0.002 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 (concurrent mode failure): 87262K->87388K(87424K), 0.0099791 secs] 126375K->125359K(126720K), [Metaspace: 2706K->2706K(1056768K)], 0.0100690 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-23T21:50:35.070-0800: [Full GC (Allocation Failure) 2020-10-23T21:50:35.070-0800: [CMS: 87388K->87388K(87424K), 0.0024351 secs] 126601K->125395K(126720K), [Metaspace: 2706K->2706K(1056768K)], 0.0025028 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:50:35.072-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 87388K(87424K)] 125524K(126720K), 0.0001882 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:50:35.073-0800: [CMS-concurrent-mark-start]
2020-10-23T21:50:35.073-0800: [Full GC (Allocation Failure) 2020-10-23T21:50:35.073-0800: [CMS2020-10-23T21:50:35.074-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 (concurrent mode failure): 87388K->87249K(87424K), 0.0137359 secs] 126364K->125323K(126720K), [Metaspace: 2706K->2706K(1056768K)], 0.0139249 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2020-10-23T21:50:35.088-0800: [Full GC (Allocation Failure) 2020-10-23T21:50:35.088-0800: [CMS: 87249K->87249K(87424K), 0.0024838 secs] 125934K->125323K(126720K), [Metaspace: 2706K->2706K(1056768K)], 0.0025611 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2020-10-23T21:50:35.091-0800: [Full GC (Allocation Failure) 2020-10-23T21:50:35.091-0800: [CMS: 87249K->87249K(87424K), 0.0022383 secs] 126078K->125323K(126720K), [Metaspace: 2706K->2706K(1056768K)], 0.0022932 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:50:35.093-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 87249K(87424K)] 126011K(126720K), 0.0001476 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:50:35.093-0800: [CMS-concurrent-mark-start]
2020-10-23T21:50:35.094-0800: [Full GC (Allocation Failure) 2020-10-23T21:50:35.094-0800: [CMS2020-10-23T21:50:35.095-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 (concurrent mode failure): 87249K->87245K(87424K), 0.0153229 secs] 126104K->125728K(126720K), [Metaspace: 2706K->2706K(1056768K)], 0.0153666 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2020-10-23T21:50:35.109-0800: [Full GC (Allocation Failure) 2020-10-23T21:50:35.109-0800: [CMS: 87245K->87245K(87424K), 0.0017375 secs] 126317K->126168K(126720K), [Metaspace: 2706K->2706K(1056768K)], 0.0017819 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2020-10-23T21:50:35.111-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 87245K(87424K)] 126456K(126720K), 0.0001370 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:50:35.111-0800: [CMS-concurrent-mark-start]
2020-10-23T21:50:35.111-0800: [Full GC (Allocation Failure) 2020-10-23T21:50:35.111-0800: [CMS2020-10-23T21:50:35.112-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 (concurrent mode failure): 87245K->87245K(87424K), 0.0024372 secs] 126478K->126312K(126720K), [Metaspace: 2706K->2706K(1056768K)], 0.0024759 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:50:35.114-0800: [Full GC (Allocation Failure) 2020-10-23T21:50:35.114-0800: [CMS: 87245K->87245K(87424K), 0.0014726 secs] 126498K->126024K(126720K), [Metaspace: 2706K->2706K(1056768K)], 0.0015148 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:50:35.116-0800: [Full GC (Allocation Failure) 2020-10-23T21:50:35.116-0800: [CMS: 87245K->87226K(87424K), 0.0102476 secs] 126024K->126005K(126720K), [Metaspace: 2706K->2706K(1056768K)], 0.0102902 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-23T21:50:35.126-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 87226K(87424K)] 126005K(126720K), 0.0001912 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:50:35.126-0800: [CMS-concurrent-mark-start]
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 at GCLogAnalysis.generateGarbage(GCLogAnalysis.java:47)
 at GCLogAnalysis.main(GCLogAnalysis.java:24)
2020-10-23T21:50:35.127-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-23T21:50:35.127-0800: [CMS-concurrent-preclean-start]
Heap
 par new generation total 39296K, used 38801K [0x00000007b8000000, 0x00000007baaa0000, 0x00000007baaa0000)
  eden space 34944K, 100% used [0x00000007b8000000, 0x00000007ba220000, 0x00000007ba220000)
  from space 4352K, 88% used [0x00000007ba660000, 0x00000007baa24648, 0x00000007baaa0000)
  to space 4352K, 0% used [0x00000007ba220000, 0x00000007ba220000, 0x00000007ba660000)
 concurrent mark-sweep generation total 87424K, used 87226K [0x00000007baaa0000, 0x00000007c0000000, 0x00000007c0000000)
 Metaspace used 2737K, capacity 4486K, committed 4864K, reserved 1056768K
  class space used 298K, capacity 386K, committed 512K, reserved 1048576K
```

###512M
```
java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx512m -Xms512m -XX:+UseConcMarkSweepGC GCLogAnalysis

正在执行...
2020-10-23T21:57:52.392-0800: [GC (Allocation Failure) 2020-10-23T21:57:52.392-0800: [ParNew: 139776K->17471K(157248K), 0.0180997 secs] 139776K->43334K(506816K), 0.0181589 secs] [Times: user=0.02 sys=0.02, real=0.02 secs]
2020-10-23T21:57:52.443-0800: [GC (Allocation Failure) 2020-10-23T21:57:52.443-0800: [ParNew: 157247K->17471K(157248K), 0.0215357 secs] 183110K->87645K(506816K), 0.0215897 secs] [Times: user=0.03 sys=0.03, real=0.02 secs]
2020-10-23T21:57:52.501-0800: [GC (Allocation Failure) 2020-10-23T21:57:52.501-0800: [ParNew: 157157K->17472K(157248K), 0.0308781 secs] 227331K->132633K(506816K), 0.0309469 secs] [Times: user=0.07 sys=0.02, real=0.03 secs]
2020-10-23T21:57:52.558-0800: [GC (Allocation Failure) 2020-10-23T21:57:52.558-0800: [ParNew: 157237K->17472K(157248K), 0.0270020 secs] 272399K->172865K(506816K), 0.0270559 secs] [Times: user=0.06 sys=0.01, real=0.03 secs]
2020-10-23T21:57:52.617-0800: [GC (Allocation Failure) 2020-10-23T21:57:52.617-0800: [ParNew: 157248K->17472K(157248K), 0.0268530 secs] 312641K->215336K(506816K), 0.0269050 secs] [Times: user=0.05 sys=0.01, real=0.03 secs]
2020-10-23T21:57:52.644-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 197864K(349568K)] 218118K(506816K), 0.0001907 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:57:52.644-0800: [CMS-concurrent-mark-start]
2020-10-23T21:57:52.649-0800: [CMS-concurrent-mark: 0.005/0.005 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-23T21:57:52.649-0800: [CMS-concurrent-preclean-start]
2020-10-23T21:57:52.650-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2020-10-23T21:57:52.650-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-23T21:57:52.673-0800: [GC (Allocation Failure) 2020-10-23T21:57:52.673-0800: [ParNew: 157248K->17472K(157248K), 0.0277934 secs] 355112K->260813K(506816K), 0.0278428 secs] [Times: user=0.07 sys=0.02, real=0.03 secs]
2020-10-23T21:57:52.722-0800: [GC (Allocation Failure) 2020-10-23T21:57:52.722-0800: [ParNew: 157248K->17471K(157248K), 0.0334848 secs] 400589K->308648K(506816K), 0.0335473 secs] [Times: user=0.06 sys=0.01, real=0.03 secs]
2020-10-23T21:57:52.777-0800: [GC (Allocation Failure) 2020-10-23T21:57:52.777-0800: [ParNew: 157247K->17472K(157248K), 0.0282449 secs] 448424K->348811K(506816K), 0.0283041 secs] [Times: user=0.06 sys=0.02, real=0.03 secs]
2020-10-23T21:57:52.806-0800: [CMS-concurrent-abortable-preclean: 0.005/0.156 secs] [Times: user=0.25 sys=0.05, real=0.15 secs]
2020-10-23T21:57:52.806-0800: [GC (CMS Final Remark) [YG occupancy: 23946 K (157248 K)]2020-10-23T21:57:52.806-0800: [Rescan (parallel) , 0.0003247 secs]2020-10-23T21:57:52.806-0800: [weak refs processing, 0.0000234 secs]2020-10-23T21:57:52.806-0800: [class unloading, 0.0002159 secs]2020-10-23T21:57:52.807-0800: [scrub symbol table, 0.0002878 secs]2020-10-23T21:57:52.807-0800: [scrub string table, 0.0001584 secs][1 CMS-remark: 331339K(349568K)] 355286K(506816K), 0.0010851 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-23T21:57:52.807-0800: [CMS-concurrent-sweep-start]
2020-10-23T21:57:52.808-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:57:52.808-0800: [CMS-concurrent-reset-start]
2020-10-23T21:57:52.808-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:57:52.825-0800: [GC (Allocation Failure) 2020-10-23T21:57:52.825-0800: [ParNew: 156904K->17470K(157248K), 0.0119478 secs] 446994K->348921K(506816K), 0.0119996 secs] [Times: user=0.04 sys=0.00, real=0.01 secs]
2020-10-23T21:57:52.838-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 331450K(349568K)] 349668K(506816K), 0.0006381 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:57:52.838-0800: [CMS-concurrent-mark-start]
2020-10-23T21:57:52.841-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2020-10-23T21:57:52.841-0800: [CMS-concurrent-preclean-start]
2020-10-23T21:57:52.841-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:57:52.841-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-23T21:57:52.841-0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:57:52.841-0800: [GC (CMS Final Remark) [YG occupancy: 41690 K (157248 K)]2020-10-23T21:57:52.841-0800: [Rescan (parallel) , 0.0003207 secs]2020-10-23T21:57:52.842-0800: [weak refs processing, 0.0000146 secs]2020-10-23T21:57:52.842-0800: [class unloading, 0.0002054 secs]2020-10-23T21:57:52.842-0800: [scrub symbol table, 0.0003214 secs]2020-10-23T21:57:52.842-0800: [scrub string table, 0.0001808 secs][1 CMS-remark: 331450K(349568K)] 373140K(506816K), 0.0011231 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:57:52.843-0800: [CMS-concurrent-sweep-start]
2020-10-23T21:57:52.843-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-23T21:57:52.843-0800: [CMS-concurrent-reset-start]
2020-10-23T21:57:52.844-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:57:52.859-0800: [GC (Allocation Failure) 2020-10-23T21:57:52.859-0800: [ParNew: 157246K->17470K(157248K), 0.0139455 secs] 396347K->301375K(506816K), 0.0140017 secs] [Times: user=0.03 sys=0.00, real=0.02 secs]
2020-10-23T21:57:52.873-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 283905K(349568K)] 301871K(506816K), 0.0002041 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:57:52.873-0800: [CMS-concurrent-mark-start]
2020-10-23T21:57:52.876-0800: [CMS-concurrent-mark: 0.003/0.003 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:57:52.876-0800: [CMS-concurrent-preclean-start]
2020-10-23T21:57:52.876-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:57:52.877-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-23T21:57:52.894-0800: [GC (Allocation Failure) 2020-10-23T21:57:52.894-0800: [ParNew: 157246K->17470K(157248K), 0.0148330 secs] 441151K->350840K(506816K), 0.0148791 secs] [Times: user=0.04 sys=0.00, real=0.01 secs]
2020-10-23T21:57:52.909-0800: [CMS-concurrent-abortable-preclean: 0.001/0.032 secs] [Times: user=0.06 sys=0.00, real=0.03 secs]
2020-10-23T21:57:52.909-0800: [GC (CMS Final Remark) [YG occupancy: 20973 K (157248 K)]2020-10-23T21:57:52.909-0800: [Rescan (parallel) , 0.0003827 secs]2020-10-23T21:57:52.909-0800: [weak refs processing, 0.0000145 secs]2020-10-23T21:57:52.909-0800: [class unloading, 0.0001974 secs]2020-10-23T21:57:52.909-0800: [scrub symbol table, 0.0002876 secs]2020-10-23T21:57:52.910-0800: [scrub string table, 0.0001568 secs][1 CMS-remark: 333370K(349568K)] 354343K(506816K), 0.0010990 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-23T21:57:52.910-0800: [CMS-concurrent-sweep-start]
2020-10-23T21:57:52.911-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:57:52.911-0800: [CMS-concurrent-reset-start]
2020-10-23T21:57:52.911-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:57:52.930-0800: [GC (Allocation Failure) 2020-10-23T21:57:52.930-0800: [ParNew: 157103K->157103K(157248K), 0.0000264 secs]2020-10-23T21:57:52.930-0800: [CMS: 303724K->297061K(349568K), 0.0624589 secs] 460827K->297061K(506816K), [Metaspace: 2706K->2706K(1056768K)], 0.0625561 secs] [Times: user=0.06 sys=0.00, real=0.06 secs]
2020-10-23T21:57:52.993-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 297061K(349568K)] 297555K(506816K), 0.0002686 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:57:52.993-0800: [CMS-concurrent-mark-start]
2020-10-23T21:57:52.996-0800: [CMS-concurrent-mark: 0.003/0.003 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-23T21:57:52.996-0800: [CMS-concurrent-preclean-start]
2020-10-23T21:57:52.997-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:57:52.997-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-23T21:57:53.022-0800: [GC (Allocation Failure) 2020-10-23T21:57:53.022-0800: [ParNew: 139776K->17468K(157248K), 0.0095679 secs] 436837K->345813K(506816K), 0.0096627 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
2020-10-23T21:57:53.032-0800: [CMS-concurrent-abortable-preclean: 0.001/0.035 secs] [Times: user=0.05 sys=0.01, real=0.04 secs]
2020-10-23T21:57:53.032-0800: [GC (CMS Final Remark) [YG occupancy: 23469 K (157248 K)]2020-10-23T21:57:53.032-0800: [Rescan (parallel) , 0.0005324 secs]2020-10-23T21:57:53.033-0800: [weak refs processing, 0.0000135 secs]2020-10-23T21:57:53.033-0800: [class unloading, 0.0002141 secs]2020-10-23T21:57:53.033-0800: [scrub symbol table, 0.0003157 secs]2020-10-23T21:57:53.034-0800: [scrub string table, 0.0002605 secs][1 CMS-remark: 328344K(349568K)] 351814K(506816K), 0.0014519 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:57:53.034-0800: [CMS-concurrent-sweep-start]
2020-10-23T21:57:53.035-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:57:53.035-0800: [CMS-concurrent-reset-start]
2020-10-23T21:57:53.035-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:57:53.056-0800: [GC (Allocation Failure) 2020-10-23T21:57:53.056-0800: [ParNew: 157244K->157244K(157248K), 0.0000245 secs]2020-10-23T21:57:53.056-0800: [CMS: 327854K->317235K(349568K), 0.0478917 secs] 485099K->317235K(506816K), [Metaspace: 2706K->2706K(1056768K)], 0.0479863 secs] [Times: user=0.05 sys=0.00, real=0.05 secs]
2020-10-23T21:57:53.104-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 317235K(349568K)] 317893K(506816K), 0.0001796 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:57:53.105-0800: [CMS-concurrent-mark-start]
2020-10-23T21:57:53.108-0800: [CMS-concurrent-mark: 0.004/0.004 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-23T21:57:53.108-0800: [CMS-concurrent-preclean-start]
2020-10-23T21:57:53.109-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:57:53.109-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-23T21:57:53.149-0800: [GC (Allocation Failure) 2020-10-23T21:57:53.149-0800: [ParNew: 139776K->17471K(157248K), 0.0164949 secs] 457011K->361806K(506816K), 0.0165454 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
2020-10-23T21:57:53.165-0800: [CMS-concurrent-abortable-preclean: 0.001/0.056 secs] [Times: user=0.04 sys=0.00, real=0.06 secs]
2020-10-23T21:57:53.166-0800: [GC (CMS Final Remark) [YG occupancy: 17740 K (157248 K)]2020-10-23T21:57:53.166-0800: [Rescan (parallel) , 0.0016855 secs]2020-10-23T21:57:53.168-0800: [weak refs processing, 0.0000301 secs]2020-10-23T21:57:53.168-0800: [class unloading, 0.0003571 secs]2020-10-23T21:57:53.168-0800: [scrub symbol table, 0.0004392 secs]2020-10-23T21:57:53.168-0800: [scrub string table, 0.0002354 secs][1 CMS-remark: 344335K(349568K)] 362076K(506816K), 0.0029188 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-23T21:57:53.169-0800: [CMS-concurrent-sweep-start]
2020-10-23T21:57:53.169-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2020-10-23T21:57:53.170-0800: [CMS-concurrent-reset-start]
2020-10-23T21:57:53.170-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:57:53.190-0800: [GC (Allocation Failure) 2020-10-23T21:57:53.190-0800: [ParNew: 157112K->157112K(157248K), 0.0000772 secs]2020-10-23T21:57:53.191-0800: [CMS: 343558K->337491K(349568K), 0.0565302 secs] 500670K->337491K(506816K), [Metaspace: 2706K->2706K(1056768K)], 0.0567515 secs] [Times: user=0.06 sys=0.00, real=0.05 secs]
2020-10-23T21:57:53.247-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 337491K(349568K)] 337651K(506816K), 0.0002236 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:57:53.248-0800: [CMS-concurrent-mark-start]
2020-10-23T21:57:53.251-0800: [CMS-concurrent-mark: 0.003/0.003 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2020-10-23T21:57:53.251-0800: [CMS-concurrent-preclean-start]
2020-10-23T21:57:53.251-0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:57:53.251-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-23T21:57:53.251-0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:57:53.252-0800: [GC (CMS Final Remark) [YG occupancy: 20625 K (157248 K)]2020-10-23T21:57:53.252-0800: [Rescan (parallel) , 0.0018058 secs]2020-10-23T21:57:53.253-0800: [weak refs processing, 0.0000377 secs]2020-10-23T21:57:53.254-0800: [class unloading, 0.0003779 secs]2020-10-23T21:57:53.254-0800: [scrub symbol table, 0.0009492 secs]2020-10-23T21:57:53.255-0800: [scrub string table, 0.0001893 secs][1 CMS-remark: 337491K(349568K)] 358117K(506816K), 0.0036203 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-23T21:57:53.255-0800: [CMS-concurrent-sweep-start]
2020-10-23T21:57:53.256-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:57:53.256-0800: [CMS-concurrent-reset-start]
2020-10-23T21:57:53.256-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:57:53.278-0800: [GC (Allocation Failure) 2020-10-23T21:57:53.278-0800: [ParNew: 139776K->139776K(157248K), 0.0000250 secs]2020-10-23T21:57:53.278-0800: [CMS: 337491K->342439K(349568K), 0.0504176 secs] 477267K->342439K(506816K), [Metaspace: 2706K->2706K(1056768K)], 0.0505072 secs] [Times: user=0.05 sys=0.00, real=0.05 secs]
2020-10-23T21:57:53.329-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 342439K(349568K)] 342687K(506816K), 0.0001677 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:57:53.329-0800: [CMS-concurrent-mark-start]
执行结束!共生成对象次数:8903
Heap
 par new generation total 157248K, used 5821K [0x00000007a0000000, 0x00000007aaaa0000, 0x00000007aaaa0000)
  eden space 139776K, 4% used [0x00000007a0000000, 0x00000007a05af7e8, 0x00000007a8880000)
  from space 17472K, 0% used [0x00000007a9990000, 0x00000007a9990000, 0x00000007aaaa0000)
  to space 17472K, 0% used [0x00000007a8880000, 0x00000007a8880000, 0x00000007a9990000)
 concurrent mark-sweep generation total 349568K, used 342439K [0x00000007aaaa0000, 0x00000007c0000000, 0x00000007c0000000)
 Metaspace used 2713K, capacity 4486K, committed 4864K, reserved 1056768K
  class space used 295K, capacity 386K, committed 512K, reserved 1048576K
```
#1g
```
java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx1g -Xms1g -XX:+UseConcMarkSweepGC GCLogAnalysis

正在执行...
2020-10-23T21:59:37.059-0800: [GC (Allocation Failure) 2020-10-23T21:59:37.059-0800: [ParNew: 272452K->34047K(306688K), 0.0347875 secs] 272452K->94689K(1014528K), 0.0348405 secs] [Times: user=0.04 sys=0.06, real=0.04 secs]
2020-10-23T21:59:37.147-0800: [GC (Allocation Failure) 2020-10-23T21:59:37.147-0800: [ParNew: 306687K->34046K(306688K), 0.0357089 secs] 367329K->169414K(1014528K), 0.0357625 secs] [Times: user=0.05 sys=0.06, real=0.04 secs]
2020-10-23T21:59:37.220-0800: [GC (Allocation Failure) 2020-10-23T21:59:37.221-0800: [ParNew: 306686K->34048K(306688K), 0.0546530 secs] 442054K->249365K(1014528K), 0.0547082 secs] [Times: user=0.13 sys=0.02, real=0.05 secs]
2020-10-23T21:59:37.312-0800: [GC (Allocation Failure) 2020-10-23T21:59:37.312-0800: [ParNew: 306688K->34048K(306688K), 0.0619285 secs] 522005K->333527K(1014528K), 0.0619761 secs] [Times: user=0.15 sys=0.03, real=0.06 secs]
2020-10-23T21:59:37.410-0800: [GC (Allocation Failure) 2020-10-23T21:59:37.410-0800: [ParNew: 306688K->34048K(306688K), 0.0512150 secs] 606167K->412895K(1014528K), 0.0512656 secs] [Times: user=0.14 sys=0.03, real=0.05 secs]
2020-10-23T21:59:37.462-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 378847K(707840K)] 413241K(1014528K), 0.0002545 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:59:37.462-0800: [CMS-concurrent-mark-start]
2020-10-23T21:59:37.474-0800: [CMS-concurrent-mark: 0.012/0.012 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2020-10-23T21:59:37.474-0800: [CMS-concurrent-preclean-start]
2020-10-23T21:59:37.476-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:59:37.476-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-23T21:59:37.511-0800: [GC (Allocation Failure) 2020-10-23T21:59:37.511-0800: [ParNew: 306688K->34048K(306688K), 0.0511538 secs] 685535K->493340K(1014528K), 0.0511990 secs] [Times: user=0.14 sys=0.03, real=0.05 secs]
2020-10-23T21:59:37.602-0800: [GC (Allocation Failure) 2020-10-23T21:59:37.602-0800: [ParNew: 306688K->34048K(306688K), 0.0595694 secs] 765980K->573842K(1014528K), 0.0596276 secs] [Times: user=0.14 sys=0.02, real=0.06 secs]
2020-10-23T21:59:37.703-0800: [GC (Allocation Failure) 2020-10-23T21:59:37.703-0800: [ParNew: 306688K->34048K(306688K), 0.0525007 secs] 846482K->644826K(1014528K), 0.0525579 secs] [Times: user=0.10 sys=0.02, real=0.05 secs]
2020-10-23T21:59:37.795-0800: [GC (Allocation Failure) 2020-10-23T21:59:37.795-0800: [ParNew2020-10-23T21:59:37.862-0800: [CMS-concurrent-abortable-preclean: 0.009/0.387 secs] [Times: user=0.64 sys=0.11, real=0.39 secs]
: 306688K->34048K(306688K), 0.0673848 secs] 917466K->738073K(1014528K), 0.0674308 secs] [Times: user=0.12 sys=0.03, real=0.07 secs]
2020-10-23T21:59:37.863-0800: [GC (CMS Final Remark) [YG occupancy: 34700 K (306688 K)]2020-10-23T21:59:37.863-0800: [Rescan (parallel) , 0.0013599 secs]2020-10-23T21:59:37.864-0800: [weak refs processing, 0.0000301 secs]2020-10-23T21:59:37.864-0800: [class unloading, 0.0002408 secs]2020-10-23T21:59:37.864-0800: [scrub symbol table, 0.0003080 secs]2020-10-23T21:59:37.865-0800: [scrub string table, 0.0001628 secs][1 CMS-remark: 704025K(707840K)] 738725K(1014528K), 0.0021873 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-23T21:59:37.865-0800: [CMS-concurrent-sweep-start]
2020-10-23T21:59:37.866-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-23T21:59:37.866-0800: [CMS-concurrent-reset-start]
2020-10-23T21:59:37.867-0800: [CMS-concurrent-reset: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
执行结束!共生成对象次数:10138
Heap
 par new generation total 306688K, used 236324K [0x0000000780000000, 0x0000000794cc0000, 0x0000000794cc0000)
  eden space 272640K, 74% used [0x0000000780000000, 0x000000078c5892d8, 0x0000000790a40000)
  from space 34048K, 100% used [0x0000000792b80000, 0x0000000794cc0000, 0x0000000794cc0000)
  to space 34048K, 0% used [0x0000000790a40000, 0x0000000790a40000, 0x0000000792b80000)
 concurrent mark-sweep generation total 707840K, used 570242K [0x0000000794cc0000, 0x00000007c0000000, 0x00000007c0000000)
 Metaspace used 2713K, capacity 4486K, committed 4864K, reserved 1056768K
  class space used 295K, capacity 386K, committed 512K, reserved 1048576K
```
#2g
```
java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx2g -Xms2g -XX:+UseConcMarkSweepGC GCLogAnalysis

正在执行...
2020-10-23T22:00:19.580-0800: [GC (Allocation Failure) 2020-10-23T22:00:19.580-0800: [ParNew: 272640K->34047K(306688K), 0.0341726 secs] 272640K->86577K(2063104K), 0.0342294 secs] [Times: user=0.05 sys=0.05, real=0.03 secs]
2020-10-23T22:00:19.657-0800: [GC (Allocation Failure) 2020-10-23T22:00:19.657-0800: [ParNew: 306687K->34048K(306688K), 0.0417726 secs] 359217K->162380K(2063104K), 0.0418170 secs] [Times: user=0.06 sys=0.06, real=0.04 secs]
2020-10-23T22:00:19.738-0800: [GC (Allocation Failure) 2020-10-23T22:00:19.738-0800: [ParNew: 306688K->34048K(306688K), 0.0531948 secs] 435020K->236420K(2063104K), 0.0532439 secs] [Times: user=0.14 sys=0.03, real=0.06 secs]
2020-10-23T22:00:19.828-0800: [GC (Allocation Failure) 2020-10-23T22:00:19.828-0800: [ParNew: 306688K->34048K(306688K), 0.0555150 secs] 509060K->317880K(2063104K), 0.0555609 secs] [Times: user=0.17 sys=0.02, real=0.06 secs]
2020-10-23T22:00:19.926-0800: [GC (Allocation Failure) 2020-10-23T22:00:19.926-0800: [ParNew: 306688K->34046K(306688K), 0.0525111 secs] 590520K->396227K(2063104K), 0.0525555 secs] [Times: user=0.15 sys=0.02, real=0.05 secs]
2020-10-23T22:00:20.018-0800: [GC (Allocation Failure) 2020-10-23T22:00:20.018-0800: [ParNew: 306686K->34046K(306688K), 0.0636598 secs] 668867K->474959K(2063104K), 0.0637126 secs] [Times: user=0.14 sys=0.03, real=0.07 secs]
2020-10-23T22:00:20.119-0800: [GC (Allocation Failure) 2020-10-23T22:00:20.119-0800: [ParNew: 306686K->34048K(306688K), 0.0495491 secs] 747599K->548052K(2063104K), 0.0496024 secs] [Times: user=0.11 sys=0.03, real=0.05 secs]
2020-10-23T22:00:20.204-0800: [GC (Allocation Failure) 2020-10-23T22:00:20.204-0800: [ParNew: 306688K->34048K(306688K), 0.0555261 secs] 820692K->627860K(2063104K), 0.0555795 secs] [Times: user=0.14 sys=0.02, real=0.06 secs]
2020-10-23T22:00:20.305-0800: [GC (Allocation Failure) 2020-10-23T22:00:20.305-0800: [ParNew: 306688K->34046K(306688K), 0.0519225 secs] 900500K->696393K(2063104K), 0.0519702 secs] [Times: user=0.14 sys=0.03, real=0.05 secs]
2020-10-23T22:00:20.397-0800: [GC (Allocation Failure) 2020-10-23T22:00:20.397-0800: [ParNew: 306686K->34046K(306688K), 0.0560130 secs] 969033K->781355K(2063104K), 0.0560590 secs] [Times: user=0.15 sys=0.03, real=0.06 secs]
执行结束!共生成对象次数:10403
Heap
 par new generation total 306688K, used 45198K [0x0000000740000000, 0x0000000754cc0000, 0x0000000754cc0000)
  eden space 272640K, 4% used [0x0000000740000000, 0x0000000740ae3db0, 0x0000000750a40000)
  from space 34048K, 99% used [0x0000000750a40000, 0x0000000752b7faa0, 0x0000000752b80000)
  to space 34048K, 0% used [0x0000000752b80000, 0x0000000752b80000, 0x0000000754cc0000)
 concurrent mark-sweep generation total 1756416K, used 747309K [0x0000000754cc0000, 0x00000007c0000000, 0x00000007c0000000)
 Metaspace used 2713K, capacity 4486K, committed 4864K, reserved 1056768K
  class space used 295K, capacity 386K, committed 512K, reserved 1048576K
```
#4g
```
java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx4g -Xms4g -XX:+UseConcMarkSweepGC GCLogAnalysis

正在执行...
2020-10-23T22:00:28.486-0800: [GC (Allocation Failure) 2020-10-23T22:00:28.486-0800: [ParNew: 272640K->34048K(306688K), 0.0453329 secs] 272640K->85186K(4160256K), 0.0453872 secs] [Times: user=0.07 sys=0.05, real=0.05 secs]
2020-10-23T22:00:28.573-0800: [GC (Allocation Failure) 2020-10-23T22:00:28.573-0800: [ParNew: 306688K->34048K(306688K), 0.0552567 secs] 357826K->163477K(4160256K), 0.0553112 secs] [Times: user=0.08 sys=0.06, real=0.05 secs]
2020-10-23T22:00:28.674-0800: [GC (Allocation Failure) 2020-10-23T22:00:28.674-0800: [ParNew: 306688K->34048K(306688K), 0.0628686 secs] 436117K->238355K(4160256K), 0.0629212 secs] [Times: user=0.18 sys=0.02, real=0.06 secs]
2020-10-23T22:00:28.781-0800: [GC (Allocation Failure) 2020-10-23T22:00:28.781-0800: [ParNew: 306688K->34048K(306688K), 0.0601332 secs] 510995K->312483K(4160256K), 0.0601778 secs] [Times: user=0.17 sys=0.03, real=0.06 secs]
2020-10-23T22:00:28.881-0800: [GC (Allocation Failure) 2020-10-23T22:00:28.881-0800: [ParNew: 306688K->34048K(306688K), 0.0653720 secs] 585123K->395061K(4160256K), 0.0654842 secs] [Times: user=0.17 sys=0.03, real=0.06 secs]
2020-10-23T22:00:29.001-0800: [GC (Allocation Failure) 2020-10-23T22:00:29.001-0800: [ParNew: 306688K->34048K(306688K), 0.0673583 secs] 667701K->482763K(4160256K), 0.0674210 secs] [Times: user=0.19 sys=0.03, real=0.06 secs]
2020-10-23T22:00:29.106-0800: [GC (Allocation Failure) 2020-10-23T22:00:29.106-0800: [ParNew: 306688K->34048K(306688K), 0.0689584 secs] 755403K->563545K(4160256K), 0.0690122 secs] [Times: user=0.17 sys=0.02, real=0.07 secs]
2020-10-23T22:00:29.211-0800: [GC (Allocation Failure) 2020-10-23T22:00:29.211-0800: [ParNew: 306688K->34048K(306688K), 0.0630017 secs] 836185K->640393K(4160256K), 0.0630480 secs] [Times: user=0.16 sys=0.03, real=0.06 secs]
2020-10-23T22:00:29.312-0800: [GC (Allocation Failure) 2020-10-23T22:00:29.312-0800: [ParNew: 306688K->34048K(306688K), 0.0651462 secs] 913033K->713749K(4160256K), 0.0651923 secs] [Times: user=0.18 sys=0.03, real=0.06 secs]
执行结束!共生成对象次数:9228
Heap
 par new generation total 306688K, used 45652K [0x00000006c0000000, 0x00000006d4cc0000, 0x00000006d4cc0000)
  eden space 272640K, 4% used [0x00000006c0000000, 0x00000006c0b55240, 0x00000006d0a40000)
  from space 34048K, 100% used [0x00000006d2b80000, 0x00000006d4cc0000, 0x00000006d4cc0000)
  to space 34048K, 0% used [0x00000006d0a40000, 0x00000006d0a40000, 0x00000006d2b80000)
 concurrent mark-sweep generation total 3853568K, used 679701K [0x00000006d4cc0000, 0x00000007c0000000, 0x00000007c0000000)
 Metaspace used 2713K, capacity 4486K, committed 4864K, reserved 1056768K
  class space used 295K, capacity 386K, committed 512K, reserved 1048576K
```
#8g
```
java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx8g -Xms8g -XX:+UseConcMarkSweepGC GCLogAnalysis

正在执行...
2020-10-23T22:00:39.319-0800: [GC (Allocation Failure) 2020-10-23T22:00:39.319-0800: [ParNew: 272640K->34047K(306688K), 0.0621040 secs] 272640K->88591K(8354560K), 0.0621652 secs] [Times: user=0.14 sys=0.06, real=0.07 secs]
2020-10-23T22:00:39.423-0800: [GC (Allocation Failure) 2020-10-23T22:00:39.423-0800: [ParNew: 306617K->34048K(306688K), 0.0657702 secs] 361161K->162654K(8354560K), 0.0658199 secs] [Times: user=0.15 sys=0.06, real=0.06 secs]
2020-10-23T22:00:39.527-0800: [GC (Allocation Failure) 2020-10-23T22:00:39.527-0800: [ParNew: 306688K->34047K(306688K), 0.0776078 secs] 435294K->244753K(8354560K), 0.0776545 secs] [Times: user=0.22 sys=0.02, real=0.08 secs]
2020-10-23T22:00:39.646-0800: [GC (Allocation Failure) 2020-10-23T22:00:39.646-0800: [ParNew: 306540K->34048K(306688K), 0.0755969 secs] 517246K->330552K(8354560K), 0.0756764 secs] [Times: user=0.22 sys=0.03, real=0.08 secs]
2020-10-23T22:00:39.759-0800: [GC (Allocation Failure) 2020-10-23T22:00:39.759-0800: [ParNew: 306688K->34048K(306688K), 0.0972630 secs] 603192K->410487K(8354560K), 0.0973209 secs] [Times: user=0.17 sys=0.03, real=0.10 secs]
2020-10-23T22:00:39.905-0800: [GC (Allocation Failure) 2020-10-23T22:00:39.905-0800: [ParNew: 306688K->34048K(306688K), 0.0694317 secs] 683127K->483620K(8354560K), 0.0694822 secs] [Times: user=0.18 sys=0.03, real=0.07 secs]
2020-10-23T22:00:40.010-0800: [GC (Allocation Failure) 2020-10-23T22:00:40.010-0800: [ParNew: 306688K->34048K(306688K), 0.0830579 secs] 756260K->573119K(8354560K), 0.0831115 secs] [Times: user=0.20 sys=0.02, real=0.08 secs]
2020-10-23T22:00:40.129-0800: [GC (Allocation Failure) 2020-10-23T22:00:40.129-0800: [ParNew: 306516K->34048K(306688K), 0.0759220 secs] 845588K->648464K(8354560K), 0.0759667 secs] [Times: user=0.20 sys=0.02, real=0.08 secs]
执行结束!共生成对象次数:8200
Heap
 par new generation total 306688K, used 45547K [0x00000005c0000000, 0x00000005d4cc0000, 0x00000005d4cc0000)
  eden space 272640K, 4% used [0x00000005c0000000, 0x00000005c0b3adc8, 0x00000005d0a40000)
  from space 34048K, 100% used [0x00000005d0a40000, 0x00000005d2b80000, 0x00000005d2b80000)
  to space 34048K, 0% used [0x00000005d2b80000, 0x00000005d2b80000, 0x00000005d4cc0000)
 concurrent mark-sweep generation total 8047872K, used 614416K [0x00000005d4cc0000, 0x00000007c0000000, 0x00000007c0000000)
 Metaspace used 2713K, capacity 4486K, committed 4864K, reserved 1056768K
  class space used 295K, capacity 386K, committed 512K, reserved 1048576K
```
## Java虚拟机

### 测试用jmap查看运行的java程序的堆的使用情况
```
jmap -heap [process_id]

Heap Configuration:
   MinHeapFreeRatio         = 0
   MaxHeapFreeRatio         = 100
   MaxHeapSize              = 734003200 (700.0MB)
   NewSize                  = 65536000 (62.5MB)
   MaxNewSize               = 244318208 (233.0MB)
   OldSize                  = 131596288 (125.5MB)
   NewRatio                 = 2  // 老年代与新生代的比例
   SurvivorRatio            = 8  // 新生代中eden:survivor
   MetaspaceSize            = 21807104 (20.796875MB)
   CompressedClassSpaceSize = 1073741824 (1024.0MB)
   MaxMetaspaceSize         = 17592186044415 MB
   G1HeapRegionSize         = 0 (0.0MB)

Heap Usage:
PS Young Generation
Eden Space:
   capacity = 49807360 (47.5MB)
   used     = 17762656 (16.939788818359375MB)
   free     = 32044704 (30.560211181640625MB)
   35.66271330180921% used
From Space:
   capacity = 7864320 (7.5MB)
   used     = 5501008 (5.2461700439453125MB)
   free     = 2363312 (2.2538299560546875MB)
   69.94893391927083% used
To Space:
   capacity = 7864320 (7.5MB)
   used     = 0 (0.0MB)
   free     = 7864320 (7.5MB)
   0.0% used
PS Old Generation
   capacity = 131596288 (125.5MB)
   used     = 90128 (0.0859527587890625MB)
   free     = 131506160 (125.41404724121094MB)
   0.06848825401518924% used

```
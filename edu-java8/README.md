# java 中间操作 和 终端操作

|操作|类型|返回类型|使用的类型/函数式接口|函数描述符|
|----|----|----|----|----|
|filter|中间|Stream<T>|Predicate<T>|T -> Boolean|
|distinct|中间<br>(有状态 无界)|Stream<T>|||
|skip|中间<br>(有状态 有界)|Stream<T>|long||
|limit|中间<br>(有状态 有界)|Stream<T>|long||
|map|中间|Stream<R>|Function<T, R>|T->R|
|flatMap|中间|Stream<R>|Function<T, Stream<R>>|T->Stream<R>|
|sorted|中间<br>(有状态 无界)|Stream<T>|Comparator<T>|(T, T) -> int|
|anyMatch|终端|boolean|Predicate<T>|T -> boolean|
|noneMatch|终端|boolean|Predicate<T>|T -> boolean|
|allMatch|终端|boolean|Predicate<T>|T -> boolean|
|findAny|终端|Optional<T>||
|findFirst|终端|Optional<T>||
|forEach|终端|void|Consumer<T>|T -> void
|collect|终端|R|Collector<T, A, R>||
|reduce|终端(有状态-有界)|Optional<T>|BinaryOperator<T>|(T, T) -> T|
|count|终端|long|||
# 实现原理
## 整个调用流程有四个角色
1. Service API
    + 定义对外服务的接口规范
2. Consumer Proxy
    + Service API 接口的代理, 内部逻辑通过Sockety与服务的提供方进行通信,
      包括写入调用参数与获取调用返回的结果对象, 通过代理使通信及获取返回结果等复杂逻辑对接口调用方透明
3. Provider Reflect
    + 服务的提供方, 通过接收Consumer Proxy通过Socket写入的参数, 定位到具体的服务实现.
      通过java反射技术实现服务的调用, 然后将调用结果写入Socket, 返回到Provider Proxy
4. Service Impl
    + 远程服务的实现类
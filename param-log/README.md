增加注解@ParamLog，注解可作用于方法和类上，用于调用时打印入参和出参。

打印结果如下：
```
{
  "method": "logTest",
  "response": {
    "id": "123",
    "name": "test",
    "address": "hhh"
  },
  "className": "com.example.ParamLogController",
  "params": {
    "person": {
      "id": "123",
      "name": "test",
      "address": "hhh"
    }
  }
}
```
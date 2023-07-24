# 校园二手交易平台

# 1 接口说明
### 1.1 待转让物品相关接口
#### 1.1.1 发布待转让物品

1) 基本信息:
   * 请求路径: /commodity
   * 请求方式: POST
   * 接口描述: 用于发布待转让物品

2) 请求参数:

   参数样式: application/json

   参数说明:
   
   | 参数名         | 类型        | 是否必须 | 备注    |
   |-------------|-----------|------|-------|
   | name        | string    | 必须   | 商品名称  |
   | description | string    | 非必须  | 商品描述  |
   | publisher   | int       | 必须   | 发布者id |
   | type        | string    | 必须   | 商品类型  | 
   | price       | 浮点数(两位小数) | 必须   | 商品价格  |
   | stock       | int       | 必须   | 商品库存  | 
   
   请求数据样例:
   ```json
   {
      "name": "name",
      "description": "description",
      "publisher": 1,
      "type":"type",
      "price":10.0,
      "stock":1
   }
   ```
3) 响应数据:

   参数样式: application/json

   参数说明:

   | 参数名  | 类型     | 是否必须 | 备注              |
   |------|--------|------|-----------------|
   | code | number | 必须   | 响应码，1代表成功，0代表失败 |
   | msg  | string | 非必须  | 提示信息            |
   | data | object | 非必须  | 返回的数据           |

响应数据样例:
```json
{
    "code": 1,
    "msg": "Success.",
    "data": null
}
```

#### 1.1.2 删除待转让物品

1) 基本信息:
   * 请求路径: /commodity
   * 请求方式: DELETE
   * 接口描述: 根据给定的物品id删除待转让物品
2) 请求参数:

   参数样式: application/x-www-form-urlencoded

   参数说明:

   | 参数名 | 类型  | 是否必须 | 备注   |
   |-----|-----|------|------|
   | id  | int | 必须   | 物品id |
   请求数据样例:
   ```text
   'id={id}'
   ```
3) 响应数据:

   参数样式: application/json

   参数说明:
   
   | 参数名  | 类型     | 是否必须 | 备注              |
   |------|--------|------|-----------------|
   | code | number | 必须   | 响应码，1代表成功，0代表失败 |
   | msg  | string | 非必须  | 提示信息            |
   | data | object | 非必须  | 返回的数据           |
   
   响应数据样例:
   ```json
   {
       "code": 1,
       "msg": "Success.",
       "data": null
   }
   ```

#### 1.1.3 修改待转让物品

1) 基本信息:
   * 请求路径: /commodity
   * 请求方式: PUT
   * 接口描述: 根据给定的物品JSON数据修改待转让物品
2) 请求参数:

   参数样式: application/json

   参数说明:

   | 参数名         | 类型        | 是否必须 | 备注    |
   |-------------|-----------|------|-------|
   | name        | string    | 必须   | 商品名称  |
   | description | string    | 非必须  | 商品描述  |
   | publisher   | int       | 必须   | 发布者id |
   | type        | string    | 必须   | 商品类型  | 
   | price       | 浮点数(两位小数) | 必须   | 商品价格  |
   | stock       | int       | 必须   | 商品库存  | 
   请求数据样例:
   ```json
   {
       "name": "new name",
       "description": "new description",
       "publisher": 2,
       "type":"new type",
       "price":20.0,
       "stock":2
   }
   ```
3) 响应数据:

   参数样式: application/json

   参数说明:

   | 参数名  | 类型     | 是否必须 | 备注              |
      |------|--------|------|-----------------|
   | code | number | 必须   | 响应码，1代表成功，0代表失败 |
   | msg  | string | 非必须  | 提示信息            |
   | data | object | 非必须  | 返回的数据           |

   响应数据样例:
   ```json
   {
       "code": 1,
       "msg": "Success.",
       "data": null
   }
   ```

#### 1.1.4 查询该用户待转让物品

1) 基本信息:
   * 请求路径: /commodity
   * 请求方式: GET
   * 接口描述: 根据用户id和物品名称name返回该用户所有待转让物品
2) 请求参数:

   参数样式: 简单参数

   参数说明:

   | 参数名    | 类型     | 是否必须 | 备注      |
   |--------|--------|------|---------|
   | userId | int    | 必须   | 用户id    |
   | name   | string | 非必须  | 物品包含的名称 |
   请求数据样例:
   ```http request
   /commodity?userId={id}&name={name}
   ```
3) 响应数据:

   参数样式: application/json

   参数说明:

   | 参数名           | 类型     | 是否必须 | 备注              |
   |---------------|--------|------|-----------------|
   | code          | number | 必须   | 响应码，1代表成功，0代表失败 |
   | msg           | string | 非必须  | 提示信息            |
   | data          | object | 非必须  | 返回的物品列表         |
   | {id}          | int    | 必须   | 物品id            |
   | {name}        | string | 必须   | 物品名称            |
   | {description} | string | 非必须  | 物品描述            |
   | {publisher}   | int    | 必须   | 物品发布者id         |
   | {type}        | string | 必须   | 物品类型            |
   | {price}       | 两位浮点数  | 必须   | 物品价格            |
   | {stock}       | int    | 必须   | 物品库存            |

   响应数据样例:
   ```json
   {
       "code": 1,
       "msg": "Success.",
       "data": [
        {
            "id": 1,
            "name": "name1",
            "description": "description1",
            "publisher": 1,
            "type": "type1",
            "price": 15.00,
            "stock": 3
        },
        {
            "id": 2,
            "name": "name2",
            "description": "description2",
            "publisher": 1,
            "type": "type2",
            "price": 23.30,
            "stock": 2
        }
    ]
   }
   ```
   

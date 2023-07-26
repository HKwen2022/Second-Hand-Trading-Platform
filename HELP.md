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
   * 请求路径: /commodity/{id}
   * 请求方式: DELETE
   * 接口描述: 根据给定的物品id删除待转让物品
2) 请求参数:

   参数样式: 路径参数

   参数说明:

   | 参数名 | 类型  | 是否必须 | 备注   |
   |-----|-----|------|------|
   | id  | int | 必须   | 物品id |
   请求数据样例:
   ```http request
   /commodity/{id}
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

#### 1.1.4 查询待转让物品

1) 基本信息:
   * 请求路径: /commodity
   * 请求方式: GET
   * 接口描述: 根据用户id和物品名称name返回该用户所有待转让物品
2) 请求参数:

   参数样式: 简单参数

   参数说明:

   | 参数名    | 类型     | 是否必须 | 备注      |
   |--------|--------|------|---------|
   | userId | int    | 非必须  | 用户id    |
   | name   | string | 非必须  | 物品包含的名称 |
   请求数据样例:
   ```http request
   /commodity?id={id}&name={name}
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

#### 1.1.5 查询所有待转让物品(管理员)

1) 基本信息:
   * 请求路径: /commodity/all
   * 请求方式: GET
   * 接口描述: 返回所有待转让物品
2) 请求参数:

   参数样式: 无

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

### 1.2 用户相关接口
#### 1.2.1 用户登录

1) 基本信息:
   * 请求路径: /user/login
   * 请求方式: POST
   * 接口描述: 用于登录用户

2) 请求参数:

   参数样式: application/json

   参数说明:

   | 参数名      | 类型     | 是否必须 | 备注   |
   |----------|--------|------|------|
   | name     | string | 必须   | 用户名称 |
   | password | string | 必须   | 用户密码 |

   请求数据样例:
   ```json
   {
    "name": "Tom",
    "password": "123456"
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
   "data": "eyJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6IjEyMzQ1NiIsIm5hbWUiOiJUb20iLCJpZCI6MSwiZXhwIjoxNjkwNDQzODg4fQ.DhX6zzhyPPpUsMxzt1o4-CBctus9339224sje5mQ6TM"
}
```

### 1.4 购物车相关接口
#### 1.4.1 加入购物车

1) 基本信息:
   * 请求路径: /shop_car
   * 请求方式: POST
   * 接口描述: 用于添加一项商品到购物车

2) 请求参数:

   参数样式: application/json

   参数说明:

   | 参数名    | 类型  | 是否必须 | 备注   |
   |--------|-----|------|------|
   | uid    | int | 必须   | 用户id |
   | cid    | int | 必须   | 商品id | 
   | number | int | 必须   | 购买数量 |

   请求数据样例:
   ```json
   {
   "uid": 1,
   "cid": 2,
   "number": 3
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

#### 1.4.2 查看用户购物车

1) 基本信息:
   * 请求路径: /shop_car/{id}
   * 请求方式: GET
   * 接口描述: 用于查看id为{id}的用户的购物车

2) 请求参数:

   参数样式: 路径参数

   参数说明:

   | 参数名   | 类型  | 是否必须 | 备注   |
   |-------|-----|------|------|
   | id    | int | 必须   | 用户id |

   请求数据样例:
   ```http request
   /shop_car/1
   ```
3) 响应数据:

   参数样式: application/json

   参数说明:

   | 参数名      | 类型     | 是否必须 | 备注               |
   |----------|--------|------|------------------|
   | code     | number | 必须   | 响应码，1代表成功，0代表失败  |
   | msg      | string | 非必须  | 提示信息             |
   | data     | object | 非必须  | 返回的数据(该用户的购物车列表) |
   | {id}     | int    | 必须   | 购物车id            |
   | {uid}    | int    | 必须   | 购物车所属用户id        |
   | {cid}    | int    | 必须   | 购物车对应商品id        |
   | {number} | int    | 必须   | 购买该商品数量          |

响应数据样例:
```json
{
   "code": 1,
   "msg": "Success.",
   "data": [
      {
         "id": 1,
         "uid": 1,
         "cid": 1,
         "number": 1
      },
      {
         "id": 2,
         "uid": 1,
         "cid": 2,
         "number": 3
      }
   ]
}
```

#### 1.4.3 查看用户购物车

1) 基本信息:
   * 请求路径: /shop_car/all
   * 请求方式: GET
   * 接口描述: 用于查看所有用户的购物车

2) 请求参数:

   参数样式: 无

3) 响应数据:

   参数样式: application/json

   参数说明:

   | 参数名  | 类型     | 是否必须 | 备注                |
   |------|--------|------|-------------------|
   | code | number | 必须   | 响应码，1代表成功，0代表失败   |
   | msg  | string | 非必须  | 提示信息              |
   | data | object | 非必须  | 返回的数据(所有用户的购物车列表) |

响应数据样例:
```json
{
   "code": 1,
   "msg": "Success.",
   "data": [
      {
         "id": 1,
         "uid": 1,
         "cid": 1,
         "number": 1
      },
      {
         "id": 2,
         "uid": 2,
         "cid": 2,
         "number": 2
      }
   ]
}
```

#### 1.4.4 查看根据条件筛选的购物车

1) 基本信息:
   * 请求路径: /shop_car/all
   * 请求方式: POST
   * 接口描述: 用于得到根据条件筛选的购物车

2) 请求参数:

   参数样式: 简单参数 + application/json

   参数说明:

   | 参数名         | 类型        | 是否必须 | 备注    |
   |-------------|-----------|------|-------|
   | userId      | string    | 非必须  | 用户id  |
   | name        | string    | 非必须  | 商品名称  |
   | description | string    | 非必须  | 商品描述  |
   | publisher   | int       | 非必须  | 发布者id |
   | type        | string    | 非必须  | 商品类型  | 
   | price       | 浮点数(两位小数) | 非必须  | 商品价格  |
   | stock       | int       | 非必须  | 商品库存  | 
   请求数据样例: 查看id为1的用户中满足商品名称含有"nnn"、商品描述含有"ddd"条件的购物车列表
   ```http request
   /shop_car/all?userId=1
   ```
   ```json
   {
       "name": "nnn",
       "description": "ddd"
   }
   ```

3) 响应数据:

   参数样式: application/json

   参数说明:

   | 参数名  | 类型     | 是否必须 | 备注                |
   |------|--------|------|-------------------|
   | code | number | 必须   | 响应码，1代表成功，0代表失败   |
   | msg  | string | 非必须  | 提示信息              |
   | data | object | 非必须  | 返回的数据(所有用户的购物车列表) |

响应数据样例:
```json
{
   "code": 1,
   "msg": "Success.",
   "data": [
      {
         "id": 1,
         "uid": 1,
         "cid": 1,
         "number": 1
      },
      {
         "id": 2,
         "uid": 2,
         "cid": 2,
         "number": 2
      }
   ]
}
```
#### 1.4.5 查看用户购物车

1) 基本信息:
   * 请求路径: /shop_car/{id}
   * 请求方式: DELETE
   * 接口描述: 用于删除id为{id}的用户的购物车

2) 请求参数:

   参数样式: 路径参数

   参数说明:

   | 参数名   | 类型  | 是否必须 | 备注    |
   |-------|-----|------|-------|
   | id    | int | 必须   | 购物车id |

   请求数据样例: 
   ```http request
   /shop_car/1
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

#### 1.4.6 修改用户购物车

1) 基本信息:
   * 请求路径: /shop_car
   * 请求方式: PUT
   * 接口描述: 根据提供的JSON修改用户的购物车信息

2) 请求参数:

   参数样式: application/json

   参数说明:

   | 参数名    | 类型  | 是否必须 | 备注    |
   |--------|-----|------|-------|
   | id     | int | 必须   | 购物车id |
   | uid    | int | 非必须  | 用户id  |
   | cid    | int | 非必须  | 商品id  | 
   | number | int | 非必须  | 购买数量  |

   请求数据样例:
   ```json
   {
   "id": 1,
   "uid": 2,
   "cid": 3,
   "number": 4
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

# 📱 Mobile Price Classification

一个基于机器学习的手机价格等级预测系统，结合 Java Spring Boot 和 Python 实现，支持通过 API 提交手机参数并返回价格区间预测结果。

---

## 🧩 项目结构

```
mobile-price-classification/
│
├── classification-server/      # Spring Boot 后端服务
│   ├── controller/             # 请求处理器 (API 接口)
│   ├── service/                # 调用 Python 模型的服务逻辑
│   ├── model/                  # Device 实体类（JPA）
│   ├── repository/             # JPA 数据库操作层
│   ├── resources/
│   │   ├── application.properties  # 环境配置
│   │   └── schema.sql         # 自动建表 SQL 脚本
│   └── ...
│
├── ml-model/                   # Python 训练 + 预测服务
│   ├── train.py                # 模型训练脚本（使用 scikit-learn）
│   ├── predict.py              # Flask 服务端，用于预测
│   ├── model.pkl               # 训练好的模型
│   └── ...
```

---

## 🚀 部署方式

### 后端（Spring Boot）

```bash
# 启动后端服务（默认端口 8080）
cd classification-server
./mvnw spring-boot:run
```

确保 `.env` 中配置了 Python 服务地址，例如：

```
PYTHON_API_URL=http://localhost:5010/predict
```

---

## 🤖 Python 预测服务（Flask）

```bash
# 启动 Python Flask 服务（默认端口 5010）
cd ml-model
python predict.py
```

模型会读取 `model.pkl` 并接收来自 Java 的 POST 请求。

---

## 📡 API 调用方式

向后端 Java 接口发送如下请求：

```
POST /api/devices/predict
Content-Type: application/json
```

### 示例：

```bash
curl -X POST http://localhost:8080/api/devices/predict \
  -H "Content-Type: application/json" \
  -d '{
    "battery_power": 1200,
    "blue": true,
    "clock_speed": 1.5,
    "dual_sim": true,
    "fc": 5,
    "four_g": true,
    "int_memory": 16,
    "m_dep": 0.5,
    "mobile_wt": 130,
    "n_cores": 4,
    "pc": 13,
    "px_height": 800,
    "px_width": 1280,
    "ram": 2048,
    "sc_h": 12,
    "sc_w": 7,
    "talk_time": 10,
    "three_g": true,
    "touch_screen": true,
    "wifi": true
  }'
```

### 返回结果：

```json
{
  "success": true,
  "message": "Predict price range successfully",
  "data": 1
}
```

---

## 📈 模型选择与性能

- 模型：RandomForestClassifier（sklearn）
- 准确率：约 88%
- 特征工程：已标准化字段匹配，避免字段不一致问题

---

## 🔮 后续改进方向

- 支持模型自动更新与版本控制
- 前端页面展示预测过程和可视化结果
- 增加用户登录与设备记录保存功能
- 使用 FastAPI 重构 Python 服务提高性能

---

## 👨‍💻 作者

Elan Yin（殷玉龙）  
Monash University · AI Master's Student  
[GitHub](https://github.com/elanyin)

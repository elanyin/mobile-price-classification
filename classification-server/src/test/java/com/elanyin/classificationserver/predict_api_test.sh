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

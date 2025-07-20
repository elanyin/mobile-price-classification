from flask import Flask, request, jsonify
import joblib
import pandas as pd

app = Flask(__name__)

scaler = joblib.load("models/scaler.pkl")
model = joblib.load("models/price_model.pkl")

@app.route('/predict', methods=['POST'])
def predict():
    data = request.get_json()

    try:
        df = pd.DataFrame([data])
        df_scaled = scaler.transform(df)
        prediction = model.predict(df_scaled)
        return jsonify({
            'success': True,
            'price_range': int(prediction[0]),
            'message': 'Prediction successful'
        })
    except Exception as e:
        return jsonify({
            'success': False,
            'message': str(e)
        }), 400


@app.route('/', methods=['GET'])
def live():
    return jsonify(
        {
            'success': True,
            'message': 'Server working!',
        }
    )

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5010)
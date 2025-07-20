import pandas as pd
import joblib

test_df = pd.read_csv('datasets/test.csv')

# load model and scaler
scaler = joblib.load('models/scaler.pkl')
model = joblib.load('models/price_model.pkl')

# features scaled
X_test = test_df.drop('id', axis=1)
X_test_scaled = scaler.transform(X_test)

# predict
predictions = model.predict(X_test_scaled)

test_df['predicted_price_range'] = predictions
print(test_df[['predicted_price_range']].head())

test_df.to_csv('results/test_with_predictions.csv', index=False)


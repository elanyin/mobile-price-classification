import joblib
import pandas as pd
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import accuracy_score, classification_report
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
import os

df = pd.read_csv('datasets/train.csv')

# split the features and label
X = df.drop('price_range', axis=1)
y = df['price_range']

# split datasets
X_train, X_val, y_train, y_val = train_test_split(X, y, test_size=0.2, random_state=42, stratify=y)

# normalization
scaler = StandardScaler()
X_train_scaled = scaler.fit_transform(X_train)
X_val_scaled = scaler.transform(X_val)

# train
model = RandomForestClassifier(n_estimators=100, random_state=42)
model.fit(X_train_scaled, y_train)

# validation
y_pred = model.predict(X_val_scaled)
print('Accuracy: ', accuracy_score(y_val, y_pred))
print(classification_report(y_val, y_pred))

# save model
os.makedirs('models', exist_ok=True)
joblib.dump(model, "models/price_model.pkl")
joblib.dump(scaler, "models/scaler.pkl")





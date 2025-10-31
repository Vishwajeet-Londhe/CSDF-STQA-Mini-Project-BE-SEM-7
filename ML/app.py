from flask import Flask, render_template_string, request, jsonify
import pickle, json, numpy as np

app = Flask(__name__)

# Load model and features
with open('rf_model.pkl', 'rb') as f:
    model = pickle.load(f)
with open('features.json', 'r') as f:
    FEATURES = json.load(f)

# Simple HTML template
HTML_PAGE = """
<!DOCTYPE html>
<html>
<head>
  <title>Stock Return Predictor</title>
  <style>
    body { font-family: Arial; max-width: 700px; margin: 50px auto; }
    label { display:block; margin-top:10px; }
    input { width:100%; padding:8px; margin-top:4px; }
    button { margin-top:15px; padding:10px 16px; }
  </style>
</head>
<body>
  <h2>📈 Stock Return Predictor</h2>
  <form method="post" action="/predict">
    {% for f in features %}
      <label>{{f}}</label>
      <input name="{{f}}" required>
    {% endfor %}
    <button type="submit">Predict Return</button>
  </form>

  {% if prediction is not none %}
  <h3>Predicted Future Return: {{prediction}}</h3>
  {% endif %}
</body>
</html>
"""

@app.route('/', methods=['GET'])
def home():
    return render_template_string(HTML_PAGE, features=FEATURES, prediction=None)

@app.route('/predict', methods=['POST'])
def predict():
    try:
        vals = [float(request.form[f]) for f in FEATURES]
        pred = model.predict([vals])[0]
        return render_template_string(HTML_PAGE, features=FEATURES, prediction=round(pred, 5))
    except Exception as e:
        return jsonify({'error': str(e)})

if __name__ == '__main__':
    app.run(debug=True)

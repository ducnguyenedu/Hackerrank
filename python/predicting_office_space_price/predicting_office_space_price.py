# Enter your code here. Read input from STDIN. Print output to STDOUT

from sklearn.linear_model import LinearRegression
from sklearn.preprocessing import PolynomialFeatures

# Read number of features (F) and number of training samples (N)
features, num_samples = map(int, input().split())

# Initialize lists for training data
X_train = []
y_train = []

# Read training data
for _ in range(num_samples):
    data = list(map(float, input().split()))
    X_train.append(data[:-1])
    y_train.append(data[-1])

# Read number of test samples (T)
num_test_samples = int(input())
X_test = [list(map(float, input().split())) for _ in range(num_test_samples)]

# Polynomial feature transformation (degree=3)
poly_transformer = PolynomialFeatures(degree=3)
X_train_poly = poly_transformer.fit_transform(X_train)
X_test_poly = poly_transformer.transform(X_test)

# Linear regression model training
model = LinearRegression()
model.fit(X_train_poly, y_train)

# Predict and output results
predictions = model.predict(X_test_poly)
for prediction in predictions:
    print(f"{prediction:.2f}")

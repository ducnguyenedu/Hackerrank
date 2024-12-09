import math
import os
import random
import re
import sys
import numpy as np
import pandas as pd
from matplotlib import pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import PolynomialFeatures, MinMaxScaler

def load_and_preprocess_data(file_path):
    """Load and preprocess the data."""
    try:
        df = pd.read_csv(file_path, header=None)
        df = df[df[0] < 4.11]  # Filter invalid time values
        return df
    except FileNotFoundError:
        print(f"Error: File '{file_path}' not found.")
        sys.exit(1)

def plot_data(df, title="Battery vs Time"):
    """Plot scatter plot of the data."""
    plt.scatter(df.iloc[:, 0], df.iloc[:, 1])
    plt.xlabel('Time')
    plt.ylabel('Battery')
    plt.title(title)
    plt.show()

def train_polynomial_regression(X, y, degree=1):
    """Train a polynomial regression model."""
    scaler = MinMaxScaler()
    X_scaled = scaler.fit_transform(X)

    poly = PolynomialFeatures(degree=degree)
    X_poly = poly.fit_transform(X_scaled)

    model = LinearRegression()
    model.fit(X_poly, y)
    return model, scaler, poly

def predict_battery_life(time_charged, model, scaler, poly):
    """Predict the battery life based on the charging time."""
    if time_charged >= 4.11:
        return 8.0  # Fully charged
    else:
        X_scaled = scaler.transform(np.array([[time_charged]]))
        X_poly = poly.transform(X_scaled)
        return model.predict(X_poly)[0]

def main():
    # Load and preprocess the data
    df = load_and_preprocess_data('trainingdata.txt')

    # Plot the data
    plot_data(df, "Raw Data: Battery vs Time")

    # Prepare features and target
    X = df.iloc[:, :1].to_numpy()
    y = df.iloc[:, -1].to_numpy()

    # Train-test split
    X_train, X_test, y_train, y_test = train_test_split(X, y, train_size=0.8, random_state=42)

    # Train the model
    model, scaler, poly = train_polynomial_regression(X_train, y_train, degree=1)

    # Evaluate the model
    y_pred_train = model.predict(poly.transform(scaler.transform(X_train)))
    y_pred_test = model.predict(poly.transform(scaler.transform(X_test)))

    # Scatter plot of the cleaned data
    plot_data(df, "Cleaned Data: Battery vs Time")

    # Predict for user input
    try:
        time_charged = float(input().strip())
        prediction = predict_battery_life(time_charged, model, scaler, poly)
        print(f"{prediction:.2f}")
    except ValueError:
        print("Error: Please enter a valid numeric value for time charged.")

if __name__ == "__main__":
    main()

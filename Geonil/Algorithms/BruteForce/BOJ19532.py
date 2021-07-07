"""
problem : 수학은 비대면강의입니다. (BOJ 19532)
comment : matrix inverse, matrix multiply
"""
import sys

In = sys.stdin.readline


def solve(params):
    a, b, c, d, e, f = params

    det = a * e - b * d
    x = (e * c - b * f) // det
    y = (a * f - c * d) // det

    return x, y


def main():
    parameters = list(map(int, In().split()))
    print(" ".join(map(str, solve(parameters))))


if __name__ == "__main__":
    main()

"""
problem : DNA (BOJ 1969)
comment : 
"""
import sys
from collections import defaultdict

In = sys.stdin.readline


def hamming_distance(dna1, dna2):
    distance = 0
    print(dna1, dna2)
    for d1, d2 in zip(dna1, dna2):
        if not d1 == d2:
            distance += 1
    print(distance)
    print()
    return distance


def solve(n, dna_lst):
    dna_distance = defaultdict(int)

    for i in range(n - 1):
        for j in range(i + 1, n):
            hd = hamming_distance(dna_lst[i], dna_lst[j])
            dna_distance[i] += hd
            dna_distance[j] += hd

    print(min(dna_distance.values()))
    print(dna_distance)


def main():
    n, l = map(int, In().split())

    dna_lst = []
    for _ in range(n):
        dna_lst.append(In().rstrip())
    dna_lst.sort()
    solve(n, dna_lst)


if __name__ == "__main__":
    main()

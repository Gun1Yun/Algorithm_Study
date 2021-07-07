'''
problem : 블랙잭 (BOJ 2798)
comment : 
'''
import sys
In = sys.stdin.readline


def checking(lst, start_idx, m):
    max_check = 0
    for idx in range(start_idx, len(lst)-1):
        for idx_j in range(idx+1, len(lst)):
            ans = lst[idx]+lst[idx_j]
            if ans <= m and ans > max_check:
                max_check = ans

    return max_check


def main():
    n, m = map(int, In().split())
    card_list = list(map(int, In().split()))
    card_list.sort()
    card_list.reverse()

    answer = 0

    for idx in range(len(card_list)):
        if m > card_list[idx]:
            tmp = checking(card_list, idx+1, m-card_list[idx])
            if tmp != 0:
                answer = max(answer, tmp + card_list[idx])
    print(answer)

if __name__ == "__main__":
    main()
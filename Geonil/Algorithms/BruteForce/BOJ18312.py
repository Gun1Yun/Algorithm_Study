"""
problem : 시각 (BOJ 18312)
comment : 클래스 이용, 시간 증가 함수 구현, [시, 분, 초]로 이용시 더 빠를듯.
"""
import sys

In = sys.stdin.readline


class Clock(object):
    def __init__(self, n):
        self.num = n
        self.hour = [0, 0]
        self.minute = [0, 0]
        self.second = [0, 0]

    def flow(self, tens, units):
        units += 1
        if units == 10:
            units = 0
            tens += 1
            if tens == 6:
                tens = 0
                return True, tens, units
        return False, tens, units

    def hours(self):
        tens, units = self.hour

        units += 1
        if units == 10:
            units = 0
            tens += 1

        self.hour = [tens, units]

    def minutes(self):
        tens, units = self.minute

        flag, tens, units = self.flow(tens, units)
        if flag:
            self.hours()

        self.minute = [tens, units]

    def seconds(self):
        tens, units = self.second

        flag, tens, units = self.flow(tens, units)
        if flag:
            self.minutes()

        self.second = [tens, units]

    def find(self, k):
        cnt = 0
        while True:
            if k in self.second or k in self.minute or k in self.hour:
                cnt += 1
            self.seconds()
            if self.hour[0] * 10 + self.hour[1] == self.num + 1:
                break

        return cnt


def main():
    n, k = map(int, In().split())
    clock = Clock(n)
    answer = clock.find(k)
    print(answer)


if __name__ == "__main__":
    main()

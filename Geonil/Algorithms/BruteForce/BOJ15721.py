"""
problem : 번데기 (BOJ 15721)
comment : 뻔=데기=뻔=데기=뻔x(n+1)=데기x(n+1)
"""
import sys

In = sys.stdin.readline


class Game(object):
    def __init__(self, num, time, option):
        self.num = num
        self.time = time
        self.option = option
        self.now = 0

    def next_person(self):
        self.now = (self.now + 1) % self.num

    def sequence(self, seq):
        time = self.time
        for _ in range(2):
            if not self.option:
                time -= 1
                if time == 0:
                    return True
            self.next_person()

            if self.option:
                time -= 1
                if time == 0:
                    return True
            self.next_person()

        for _ in range(seq + 1):
            if not self.option:
                time -= 1
                if time == 0:
                    return True
            self.next_person()

        for _ in range(seq + 1):
            if self.option:
                time -= 1
                if time == 0:
                    return True
            self.next_person()

        self.time = time
        return False

    def find(self):
        seq = 1
        while True:
            flag = self.sequence(seq)
            seq += 1
            if flag:
                break

        return self.now


def main():
    n = int(In())
    t = int(In())
    o = int(In())
    game = Game(n, t, o)
    answer = game.find()
    print(answer)


if __name__ == "__main__":
    main()

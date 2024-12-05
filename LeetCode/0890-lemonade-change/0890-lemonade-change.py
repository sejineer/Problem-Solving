class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        cost_5 = 0
        cost_10 = 0
        cost_20 = 0

        for i in bills:
            if i == 5:
                cost_5 += 1
            if i == 10:
                if cost_5 < 1:
                    return False
                else:
                    cost_5 -= 1
                    cost_10 += 1
            if i == 20:
                if cost_10 > 0 and cost_5 > 0:
                    cost_10 -= 1
                    cost_5 -= 1
                    cost_20 += 1
                else:
                    if cost_5 < 3:
                        return False
                    cost_5 -= 3
            print(f"{cost_5} {cost_10} {cost_20}")
        return True

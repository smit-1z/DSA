class MyStack:

    def __init__(self):
        self.q1 = deque()

    def push(self, x: int) -> None:
        self.q1.append(x)

    def pop(self) -> int:
        sz = len(self.q1)
        while sz > 0:
            self.q1.append(self.q1.pop())
            sz-=1
        return self.q1.pop()

    def top(self) -> int:
        return self.q1[-1]
        

    def empty(self) -> bool:
        return len(self.q1) == 0


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()
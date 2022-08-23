// Problem Link: https://leetcode.com/problems/online-stock-span/

class StockSpanner
{
public:
    StockSpanner()
    {
        i = 0;
    }

    int next(int price)
    {
        int ans = 1;
        while (!s.empty() && s.top().first <= price)
            s.pop();

        if (!s.empty())
            ans += (i - 1 - s.top().second);
        else
            ans += i;

        s.push({price, i++});
        return ans;
    }

private:
    stack<pair<int, int>> s{}; // <price, index>
    int i; // List length all the time
};

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner* obj = new StockSpanner();
 * int param_1 = obj->next(price);
 */
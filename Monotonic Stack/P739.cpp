// Problem Link: https://leetcode.com/problems/daily-temperatures/

class Solution
{
public:
    vector<int> dailyTemperatures(vector<int> &temperatures)
    {
        int n = temperatures.size();
        vector<int> res(n, 0);
        stack<int> s;
        for (int curIndex = 0; curIndex < n; curIndex++)
        {
            while (!s.empty() && temperatures[s.top()] < temperatures[curIndex])
            {
                int prevIndex = s.top();
                s.pop();
                res[prevIndex] = curIndex - prevIndex;
            }
            s.push(curIndex);
        }

        return res;
    }
};
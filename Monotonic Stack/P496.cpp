// Problem Link: https://leetcode.com/problems/next-greater-element-i/

class Solution
{
public:
    vector<int> nextGreaterElement(vector<int> &a, vector<int> &b)
    {
        map<int, int> a_index;
        stack<int> s;

        for (int i = 0; i < a.size(); i++)
            a_index[a[i]] = i;

        vector<int> res(a.size(), -1);
        for (int i = 0; i < b.size(); i++)
        {
            while (!s.empty() && b[i] > s.top())
            {
                res[a_index[s.top()]] = b[i];
                s.pop();
            }

            if (a_index.find(b[i]) != a_index.end())
                s.push(b[i]);
        }

        return res;
    }
};
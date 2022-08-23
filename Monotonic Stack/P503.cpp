// Problem Link: https://leetcode.com/problems/next-greater-element-ii/
// Circular array so wrap it :)
// [1, 2, 3] -> [1, 2, 3, 1, 2, 3]

class Solution
{
public:
    vector<int> nextGreaterElements(vector<int> &nums)
    {

        int n = nums.size();
        vector<int> res(n, -1);
        stack<int> s;
        for (int i = 0; i < 2 * n; i++)
        {
            while (!s.empty() && nums[s.top()] < nums[i % n])
            {
                res[s.top()] = nums[i % n];
                s.pop();
            }
            if (i < n)
                s.push(i);
        }

        return res;
    }
};
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if(len(s)!=len(t)):
             return False

        list=[0]*26
        for i in s:
            list[ord(i)-ord('a')]+=1
        for i in t:
            list[ord(i)-ord('a')]-=1
        for i in list:
            if i!=0:
                return False
        return True
            

            
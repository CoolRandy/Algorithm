/*
*  此题来自算法珠玑第二章问题B，又名杂耍算法
*  Problem Description：将一个n元一维向量向左旋转i个位置，即循环移位
*  Request:使用数十个额外存储空间，正比于n的时间内
*  本例取n = 12， 旋转量为rotdist = 3进行测试
*  算法描述：
*	步骤：(k表示循环移动的位数)
*	1)先将x[0]移到临时变量t中
*	2)将x[k]移动到x[0]中，x[2k]移动到x[k]中，依次类推
*	3)将x中的所有下标都对n取模，直到我们又回到从x[0]中提取元素。不过这时我们从t中提取元素，结束。
*/



#include<stdio.h>
#include<stdlib.h>
#include<conio.h>

void main()
{
	int x[12] = {1,2,3,4,5,6,7,8,9,10,11,12};
	int n = 12, rotdist = 3;
	int t = 0, j = 0, k;
	for(int i = 0; i < rotdist; i++)
	{
		t = x[i];
		j = i;
		do
		{
			k = j + rotdist;
			if(k >= n)
			{
				k -= n;
			}
			if(k == i) break;
			x[j] = x[k];
			j = k;
		}while(k != i);
		x[j] = t;
	}
	for(int m = 0; m < n; m++)
	{
		printf("%d ", x[m]);
	}
	getch();

}
/*
*  ���������㷨����ڶ�������B��������ˣ�㷨
*  Problem Description����һ��nԪһά����������תi��λ�ã���ѭ����λ
*  Request:ʹ����ʮ������洢�ռ䣬������n��ʱ����
*  ����ȡn = 12�� ��ת��Ϊrotdist = 3���в���
*  �㷨������
*	���裺(k��ʾѭ���ƶ���λ��)
*	1)�Ƚ�x[0]�Ƶ���ʱ����t��
*	2)��x[k]�ƶ���x[0]�У�x[2k]�ƶ���x[k]�У���������
*	3)��x�е������±궼��nȡģ��ֱ�������ֻص���x[0]����ȡԪ�ء�������ʱ���Ǵ�t����ȡԪ�أ�������
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
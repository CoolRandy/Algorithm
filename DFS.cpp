#include<stdio.h>
#include<stdlib.h>
#include<conio.h>

#define MaxNum 10

struct enode					/*�������ṹ*/
{
	int adjvex;      //��Ӧ���ǽ������0,1,2������
	struct enode* next;
}enode;

struct vnode					/*���嶥����ṹ*/
{
	char vertex;
	struct enode* firstedge;
}vnode;

struct ALGraph					/*����ͼ�ṹ*/
{
	struct vnode adjlist[MaxNum];//�洢���ǽ���������v1��v2������
	int n, e;

}ALGraph;

int locate_vex(struct ALGraph*G, char vex)//��λ����vex������ͼ��G�е����λ��
{
	int i;
	for(i = 0; i < G->n; i++)
	{
		if(G->adjlist[i].vertex == vex)
			return i;
	}

}

void createGraph(struct ALGraph* G)
{
	int i, j, k;
	char vex1, vex2;
	struct enode * s;

	printf("\n����������ͼ�Ķ������ƣ�");

	for(i = 0; i < G->n; i++)
	{
		scanf_s("\n%c", &G->adjlist[i].vertex);
		G->adjlist[i].firstedge = NULL;
	}

	printf("\n����������ͼ��ÿ�����Ļ�β����ͻ�ͷ�������ƣ�");
	for (k = 0; k < G->e; k++)
	{
		printf("\n�������%d�����Ļ�β�������ƣ�", k+1);
		scanf_s("\n%c", &vex1);
		printf("\n�������%d�����Ļ�ͷ�������ƣ�", k+1);
		scanf_s("\n%c", &vex2);

		i = locate_vex(G, vex1);
		j = locate_vex(G, vex2);

		s = (struct enode*)malloc(sizeof(struct enode));
		s->adjvex = j;
		s->next = G->adjlist[i].firstedge;
		G->adjlist[i].firstedge = s;
	}
}


void outGraph(struct ALGraph* G)//���ͼ�ṹ
{
	int i, j;
	struct enode* s;

	printf("\n\n����ͼ��%d������", G->n);
	for (int i = 0; i < G->n; i++)
	{
		printf("%c", G->adjlist[i].vertex);
	}
	printf("\n\n����ͼ��%d����", G->e);
	for (int i = 0; i < G->n; i++)
	{
		printf("\n%c->", G->adjlist[i].vertex);
		s = G->adjlist[i].firstedge;
		while (s)
		{
			printf("%c ", G->adjlist[s->adjvex].vertex);
			s = s->next;
		}
	}
}

int visited[MaxNum];

void DFS(struct ALGraph *G, int i)//��n�����������ѡȡһ����ʼ����
{
	struct enode *p;
	printf("���ʶ���%c", G->adjlist[i].vertex);
	visited[i] = 1;
	p = G->adjlist[i].firstedge;
	while(p)
	{
		if(!visited[p->adjvex])
		{
			DFS(G, p->adjvex);
		}
		p = p->next;
	}
}

void DFSTraverse(struct ALGraph *G)
{
	int i;
	for(i = 0; i < G->n; i++)
	{
		visited[i] = 0;
	}
	printf("\n");

	for(i = 0; i < G->n; i++)
	{
		if(!visited[i])
		{
			DFS(G, i);
		}
	}
}

void main()
{
	struct ALGraph alg;
	printf("\n����ͼ�洢�ṹ������");
	printf("\n����������ͼ�Ķ�����Ŀ��");
	scanf_s("%d",&alg.n);
	printf("\n����������ͼ�Ļ���Ŀ��");
	scanf_s("%d",&alg.e);
	createGraph(&alg);
	outGraph(&alg);
	DFSTraverse(&alg);
	getch();
}
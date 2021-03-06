#include<stdio.h>
#include<stdlib.h>
#include<conio.h>

#define MaxNum 10

struct enode					/*定义表点结结构*/
{
	int adjvex;      //对应的是结点的序号0,1,2。。。
	struct enode* next;
}enode;

struct vnode					/*定义顶点结点结构*/
{
	char vertex;
	struct enode* firstedge;
}vnode;

struct ALGraph					/*定义图结构*/
{
	struct vnode adjlist[MaxNum];//存储的是结点的名称如v1，v2。。。
	int n, e;

}ALGraph;

int locate_vex(struct ALGraph*G, char vex)//定位定点vex在有向图中G中的序号位置
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

	printf("\n请输入有向图的顶点名称：");

	for(i = 0; i < G->n; i++)
	{
		scanf_s("\n%c", &G->adjlist[i].vertex);
		G->adjlist[i].firstedge = NULL;
	}

	printf("\n请输入有向图的每条弧的弧尾顶点和弧头顶点名称：");
	for (k = 0; k < G->e; k++)
	{
		printf("\n请输入第%d条弧的弧尾顶点名称：", k+1);
		scanf_s("\n%c", &vex1);
		printf("\n请输入第%d条弧的弧头顶点名称：", k+1);
		scanf_s("\n%c", &vex2);

		i = locate_vex(G, vex1);
		j = locate_vex(G, vex2);

		s = (struct enode*)malloc(sizeof(struct enode));
		s->adjvex = j;
		s->next = G->adjlist[i].firstedge;
		G->adjlist[i].firstedge = s;
	}
}


void outGraph(struct ALGraph* G)//输出图结构
{
	int i, j;
	struct enode* s;

	printf("\n\n有向图有%d个顶点", G->n);
	for (int i = 0; i < G->n; i++)
	{
		printf("%c", G->adjlist[i].vertex);
	}
	printf("\n\n有向图有%d个弧", G->e);
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

void DFS(struct ALGraph *G, int i)//从n个结点中任意选取一个开始遍历
{
	struct enode *p;
	printf("访问顶点%c", G->adjlist[i].vertex);
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
	printf("\n有向图存储结构。。。");
	printf("\n请输入有向图的顶点数目：");
	scanf_s("%d",&alg.n);
	printf("\n请输入有向图的弧数目：");
	scanf_s("%d",&alg.e);
	createGraph(&alg);
	outGraph(&alg);
	DFSTraverse(&alg);
	getch();
}
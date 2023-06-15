SELECT empno, ename,sal,deptno
FROM emp
WHERE  EXISTS (SELECT 1 FROM emp where empno in(7566,7788) );

select empno,ename,deptno,sal from emp where sal =(select max(sal) from emp where deptno=30);
select empno,ename,deptno,sal from emp where sal >ANY(select sal from emp where deptno=30);
select empno,ename,deptno,sal from emp where sal <ANY(select sal from emp where deptno=30);
select empno,ename,deptno,sal,comm from emp where  EXISTS(select sal from emp where comm>1000);

select empno,ename,deptno,sal from emp where (sal,job)in (select sal,job from emp where comm is not null);

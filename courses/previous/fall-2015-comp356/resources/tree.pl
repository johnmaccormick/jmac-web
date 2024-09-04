/* relation to check whether some value occurs in the tree */
isin(K, node(_, K, _)).
isin(K, node(L, D, _)) :- K < D, isin(K, L).
isin(K, node(_, D, R)) :- K > D, isin(K, R).

/* do an inorder traversal of the tree, accumulating the node values in
   a list */
inorder(empty, []).
inorder(node(L, D, R), Z) :- inorder(L, LL), inorder(R, RL),
                             append(LL, [D], Z1),
                             append(Z1,  RL, Z).

/* adding a node at the proper position in the tree with no attempt at
   balancing the tree */
insert(K, empty, node(empty, K, empty)).
insert(K, node(L, D, R), node(L2, D, R)) :- K < D, insert(K, L, L2).
insert(K, node(L, D, R), node(L, D, R2)) :- K > D, insert(K, R, R2).



/* here is an actual tree to experiment with */
mytree(T) :- insert(5, empty, T1),
	insert(1, T1, T2),
	insert(12, T2, T3),
        insert(7, T3, T4),
	insert(8, T4, T5),
	insert(23, T5, T6),
	insert(3, T6, T).

/* try the following queries */
/* mytree(T),isin(8,T). */
/* mytree(T),isin(5,T). */
/* mytree(T),inorder(T,OrderedT). */

/* some simpler examples */
/* define a tree directly: */
/*    node( node(empty, 6, empty), 7, node(empty, 9, node( empty, 12, empty))). */
/* examples of how to use it: */
/*    isin(8, node( node(empty, 6, empty), 7, node(empty, 9, node( empty, 12, empty)))).*/
/*    inorder(node( node(empty, 6, empty), 7, node(empty, 9, node( empty, 12, empty))), X).*/






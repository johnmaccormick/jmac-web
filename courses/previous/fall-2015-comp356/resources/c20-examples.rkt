;;; examples mostly copied from Dybvig's book, http://www.scheme.com/tspl4/

#lang racket

(define abcde '(a b c d e))

(set! abcde (cdr abcde))

(display abcde)
(display  "\n")

(let ([abcde '(a b c d e)])
  (set! abcde (reverse abcde))
  abcde) 

(define count
  (let ([next 0])
    (lambda ()
      (let ([v next])
        (set! next (+ next 1))
        v)))) 

(define make-stack
  (lambda ()
    (let ([ls '()])
      (lambda (msg . args)
        (cond
          [(eqv? msg 'empty?) (null? ls)]
          [(eqv? msg 'push!) (set! ls (cons (car args) ls))]
          [(eqv? msg 'top) (car ls)]
          [(eqv? msg 'pop!) (set! ls (cdr ls))]
          [else "oops"]))))) 

;; exercise: define a method size, which returns the number of elements on the stack
;; exercise: define a method pop-all!, which pops all elements of the stack and returns them as a single list



(define v1 (make-vector 5 9))
(define v2 (vector 2 4 6 8 10 12))
; (vector-ref v2 3)
; (vector-length v2)
; (vector-set! v2 3 29)


;; remaining examples taken from Racket documentation
(define ht (make-hash)) 
(hash-set! ht "apple" '(red round)) 
(hash-set! ht "banana" '(yellow long)) 
;(hash-ref ht "apple") 
;(hash-ref ht "coconut") 


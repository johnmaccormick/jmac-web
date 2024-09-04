;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-advanced-reader.ss" "lang")((modname sum-fn) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #t #t none #f () #f)))
; compute f(1) + f(2) + ... + f(n)
(define (sum-fn f n)
    (if (eq? n 0) 0
        (+ (f n) (sum-fn f (- n 1)))))


; same, but tail-recursive
(define (sum-fn-tailrec f n)
  (letrec ((sum-fn-helper 
            (lambda (f n total)
              (if (eq? n 0) total
                  (sum-fn-helper f (- n 1) (+ total (f n)))))))
    (sum-fn-helper f n 0)))

; demonstrate tailrec version is faster
(time (sum-fn-tailrec sqrt 1e5))
(time (sum-fn sqrt 1e5))

; demonstrate tailrec version uses far less memory
;(sum-fn-tailrec sqrt 1e7)
;(sum-fn sqrt 1e7)
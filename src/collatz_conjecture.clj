(ns collatz-conjecture)

(defn- collatz-math [^Integer n]
  {:pre [(>= n 1)]}
  (if (zero? (mod n 2))
    (/ n 2)
    (+ (* n 3) 1)))

(defn- collatz-conj [^Integer n]
  (lazy-seq (cons n (collatz-conj (collatz-math n)))))

(defn collatz [^Integer n]
  (if (<= n 0)
    (throw (new IllegalArgumentException "Whatch out!"))
    (count (take-while #(not= 1 %) (collatz-conj n)))))
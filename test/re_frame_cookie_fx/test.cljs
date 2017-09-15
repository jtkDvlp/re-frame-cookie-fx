(ns re-frame-cookie-fx.test
  (:require [re-frame-cookie-fx.core]
            [re-frame.core :as re-frame]))

(re-frame/reg-event-fx
 :test-cookie-count
 [(re-frame/inject-cofx :cookie)]
 (fn [cofx _]
   {:cookie (update (:cookie cofx) :counter inc)}))

(re-frame/reg-event-fx
 :initialize
 [(re-frame/inject-cofx :cookie)]
 (fn [cofx _]
   {:cookie (update (:cookie cofx) :counter (fnil identity 0))
    :dispatch-n [[:test-cookie-count]
                 [:test-cookie-count]
                 [:test-cookie-count]
                 [:test-cookie-count]]}))

(re-frame/dispatch-sync [:initialize])

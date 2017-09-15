(ns re-frame-cookie-fx.core
  (:refer-clojure :exclude [get reset!])
  (:require [re-frame-cookie-fx.cookie :refer [get reset!]]
            [re-frame.core :as re-frame]))

(re-frame/reg-cofx
 :cookie
 (fn cookie-coeffect-handler
   [coeffects]
   (assoc coeffects :cookie (get ::db {}))))

(re-frame/reg-fx
 :cookie
 (fn cookie-fx-handler
   [value]
   (let [old-db (get ::db {})
         new-db (merge old-db value)]
     (reset! ::db new-db))))

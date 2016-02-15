(ns asparagus.router
    (:require [io.pedestal.http :refer [html-body]]
              [io.pedestal.http.body-params :refer [body-params]]
              [io.pedestal.http.route.definition :refer [defroutes]]
              [asparagus.handler.home :as home]))

(defroutes routes
  [[["/" ^:interceptors [body-params html-body]
     {:get home/index}]]])




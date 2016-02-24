(ns asparagus.router
    (:require [io.pedestal.http :refer [html-body json-body]]
              [io.pedestal.http.body-params :refer [body-params]]
              [io.pedestal.http.route.definition :refer [defroutes]]
              [asparagus.handler.home :as home]))

(defroutes routes
  [[["/" ^:interceptors [(body-params) html-body]
     {:get home/index}
     ["/test" {:get home/test}]
     ["/json" {:get home/json}]
     ["/user" {:get home/user}]
     ["/user/:id" {:get home/user2}]
     ["/userr/:id" {:get home/userr}]
     ["/hello" ^:interceptors [json-body]
      {:get  home/hello
       :post home/hello2}]
     ["/bot" ^:interceptors [json-body]
      {:get home/bot}
      ["/set" {:post home/set}]]]]])

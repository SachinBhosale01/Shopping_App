For ER and class diagram check the Folder or ER diagram



We Have Some Assumptions about About Database
You need to Insert data Manually for frist time 

Data Insertion Instructions:

Users: Instruct users to insert sample user data into the User table. Include fields like userId and username.
Products: Guide users to add sample product data into the Product table. Specify fields such as productId, ordered, availableQuantity, and price.
Coupons: Explain how to insert sample coupon data into the Coupon table. Include fields like couponId, couponCode, and discount.
Orders: Provide instructions for adding sample order data into the Order table. Mention fields like orderId, orderDate, quantity, and amount.
Payments: Lastly, instruct users on inserting sample payment data into the Payment table. Specify fields such as paymentId, transactionId, description, and status.
Sample Data:
User:
INSERT INTO `shopping_web_app2`.`user` (`user_id`, `username`) VALUES ('1', 'Amit');
INSERT INTO `shopping_web_app2`.`user` (`user_id`, `username`) VALUES ('2', 'Rohit');
INSERT INTO `shopping_web_app2`.`user` (`user_id`, `username`) VALUES ('3', 'Mohit');

Product:
INSERT INTO `shopping_web_app2`.`product` (`available_quantity`, `ordered`, `price`, `product_id`) VALUES ('90', '10', '100', '101');

Coupon:
INSERT INTO `shopping_web_app2`.`coupon` (`discount`, `coupon_id`, `coupon_code`) VALUES ('5', '5', 'OFF5');
INSERT INTO `shopping_web_app2`.`coupon` (`discount`, `coupon_id`, `coupon_code`) VALUES ('10', '10', 'OFF10');

Order:
INSERT INTO `shopping_web_app2`.`orders` (`amount`, `quantity`, `coupon_id`, `order_date`, `order_id`, `product_id`, `user_id`) VALUES ('950', '10', '5', '2024-02-03', '201', '101', '1');
INSERT INTO `shopping_web_app2`.`orders` (`amount`, `quantity`, `coupon_id`, `order_date`, `order_id`, `product_id`, `user_id`) VALUES ('1900', '20', '10', '2024-02-04', '202', '101', '2');
inser payment id manually for checking.

Payment:
INSERT INTO `shopping_web_app2`.`payment` (`order_id`, `payment_id`, `product_id`, `user_id`, `description`, `status`, `transaction_id`) VALUES ('201', '301', '101', '1', 'Payment Done', 'Successful ', 'tran010100001');
INSERT INTO `shopping_web_app2`.`payment` (`order_id`, `payment_id`, `product_id`, `user_id`, `description`, `status`, `transaction_id`) VALUES ('202', '302', '101', '2', 'Payment Failed from bank', 'failed', 'tran010100002');


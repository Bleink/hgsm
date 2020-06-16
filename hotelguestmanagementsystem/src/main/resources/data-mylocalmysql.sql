INSERT INTO addresses (address_id,city, state, street, zipcode)
VALUES ('1','Fairfield', 'Iowa', '1000 N 4th Str', '52557');

INSERT INTO addresses (address_id,city, state, street, zipcode)
VALUES ('2','Chantilly', 'Virginia', '1000 N Lewis Wood CT', '52547');

INSERT INTO roles (role_id, name)
VALUES ('1', 'ADMIN');

INSERT INTO roles (role_id, name)
VALUES ('2', 'GUEST');

INSERT INTO roles (role_id, name)
VALUES ('3', 'RECEPTION');

INSERT INTO users (user_id, email, enabled, first_name, last_name, password, username, address_id)
VALUES ('1', 'admin@gmail.com', 0, 'Blein', 'Yirdaw',
'$2a$10$wPowN5LTwMCmM8Q5amycVOSU/ecpHjiznEfgaWgaTKDHiCjUJs6e6','admin@gmail.com','1');

INSERT INTO roomtypes  (roomtype_id, description, image_path, price , type)

VALUES ('1','Our modern and luxuriously appointed Standard guest rooms deliver refined decadence in the nation. These rooms balance form and function, with a palette of warm tones, 48” flat-screen TVs, and spa-like marble bathrooms with custom amenities.', '/img/garden.JPG' , 100.00, 'Standard');


INSERT INTO roomtypes  (roomtype_id, description, image_path, price , type)

VALUES ('2','Our spacious Deluxe guest rooms designed with warm tones and amenities  such as spa-like marble bathrooms  and 48" flat screen TVs. The luxuriously appointed Deluxe guest rooms are available with a King bed or Two Queen/Full beds.', '/img/gallery3.JPG' , 170.00, 'Deluxe');

INSERT INTO roomtypes  (roomtype_id, description, image_path, price , type)

VALUES ('3','Our spacious Superior Deluxe guest rooms designed with warm tones luxury furnishings  such as spa-like marble bathrooms  and 48" flat screen TVs. The luxuriously appointed Deluxe guest rooms are available with a King bed or Two Queen/Full beds.', '/img/garden2.JPG' , 250.00, 'Superior Deluxe');

INSERT INTO roomtypes  (roomtype_id, description, image_path, price , type)

VALUES ('4','Our largest single rooms featuring balconies with a view. Spacious Premier Rooms include seating area with leather couch, spa-like marble bathroom filled with custom La Bottega amenities, and 48” flat-screen TVs.', '/img/gallery20.JPG' , 320.00, ' Premier Deluxe');

INSERT INTO roomtypes  (roomtype_id, description, image_path, price , type)

VALUES ('5','Our Executive One-Bedroom Suites are filled with lavish finishes, sleek furniture and lush bedding, all artfully chosen with the guest in mind. Exclusive bath amenities, custom-made  floor-to-ceiling marble bathrooms with five-piece marble bath sets.', '/img/gallery10.JPG' , 400.00, ' Executive Suite');

INSERT INTO roomtypes  (roomtype_id, description, image_path, price , type)

VALUES ('6','This suite combines a One-Bedroom Suite, with a separate a living room (with sleeper sofa) and bedroom, with our Superior King room. These adjoining rooms with connecting doors provide extra space and privacy.', '/img/gallery21.JPG' , 380.00, ' Junior Suite');

INSERT INTO roomtypes  (roomtype_id, description, image_path, price , type)

VALUES ('7','This spacious, custom designed suite features an expansive set of windows overlooking the Potomac River with romance package . Guests enter a spacious living room with chandelier , plush pink seating areas and King-size bed with master bath.', '/img/gallery15.JPG' , 500.00, 'Honeymoon Suite');







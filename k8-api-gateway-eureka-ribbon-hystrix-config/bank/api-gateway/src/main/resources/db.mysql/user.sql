/* Populate USER_PROFILE Table */
INSERT INTO USER_PROFILE(TYPE)
VALUES ('USER');

INSERT INTO USER_PROFILE(TYPE)
VALUES ('ADMIN');

INSERT INTO USER_PROFILE(TYPE)
VALUES ('DBA');

/* Populate APP_USER Table */
INSERT INTO APP_USER(sso_id, PASSWORD, first_name, last_name, email, state)
VALUES ('admin','$2a$10$A1NmbD9lUvkd8dkCEjuTwuAubGRJn1OKM5Q5OijBLe/Q.7nZo4b2m', 'Bill','Watcher','bill@xyz.com', 'Active');
/* Password should be encripted

 BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        System.out.println(b.encode("admin"));


*/

INSERT INTO APP_USER(sso_id, PASSWORD, first_name, last_name, email, state)
VALUES ('danny','abc124', 'Danny','Theys','danny@xyz.com', 'Active');

INSERT INTO APP_USER(sso_id, PASSWORD, first_name, last_name, email, state)
VALUES ('sam','abc125', 'Sam','Smith','samy@xyz.com', 'Active');

INSERT INTO APP_USER(sso_id, PASSWORD, first_name, last_name, email, state)
VALUES ('nicole','abc126', 'Nicole','warner','nicloe@xyz.com', 'Active');

INSERT INTO APP_USER(sso_id, PASSWORD, first_name, last_name, email, state)
VALUES ('kenny','abc127', 'Kenny','Roger','kenny@xyz.com', 'Active');

/* Populate JOIN Table */
INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id)
  SELECT user.id, profile.id FROM app_user USER, user_profile profile
  WHERE user.sso_id='admin' AND profile.type='USER';

INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id)
  SELECT user.id, profile.id FROM app_user USER, user_profile profile
  WHERE user.sso_id='danny' AND profile.type='USER';

INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id)
  SELECT user.id, profile.id FROM app_user USER, user_profile profile
  WHERE user.sso_id='sam' AND profile.type='ADMIN';

INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id)
  SELECT user.id, profile.id FROM app_user USER, user_profile profile
  WHERE user.sso_id='nicole' AND profile.type='DBA';

INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id)
  SELECT user.id, profile.id FROM app_user USER, user_profile profile
  WHERE user.sso_id='kenny' AND profile.type='ADMIN';

INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id)
  SELECT user.id, profile.id FROM app_user USER, user_profile profile
  WHERE user.sso_id='kenny' AND profile.type='DBA';
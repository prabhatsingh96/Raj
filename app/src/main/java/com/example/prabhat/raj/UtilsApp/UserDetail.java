package com.example.prabhat.raj.UtilsApp;

/**
 * Created by prabhat on 6/2/18.
 */


    public class UserDetail {
        private String name;
        private String email;
        private String password;
        private String contact;
        private int id;


        public UserDetail() {
        }

        public UserDetail(int id, String name, String email, String password, String contact ) {
            this.name = name;
            this.email = email;
            this.password = password;
            this.contact = contact;
            this.id = id;

        }

        public int getId(){ return id; }

        public void setId(int id){this.id = id;}
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }


    }



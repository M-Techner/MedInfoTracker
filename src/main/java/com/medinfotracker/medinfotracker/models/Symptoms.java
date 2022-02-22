package com.medinfotracker.medinfotracker.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
<<<<<<< HEAD
=======
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> e68f6f5f273a59d08c301141edfeaab44c0081a2
import com.medinfotracker.medinfotracker.models.*;
import com.medinfotracker.medinfotracker.models.User;
import com.medinfotracker.medinfotracker.models.data.*;
import com.medinfotracker.medinfotracker.controllers.*;
<<<<<<< HEAD
=======
=======
import javax.persistence.OneToMany;
>>>>>>> 0ebf3c6f365df4e08ef9b35c3e86556482c8281e
=======
import javax.persistence.OneToMany;
>>>>>>> 0ebf3c6f365df4e08ef9b35c3e86556482c8281e
>>>>>>> e68f6f5f273a59d08c301141edfeaab44c0081a2
import javax.validation.constraints.NotNull;
@Entity
public class Symptoms extends AbstractEntity {

<<<<<<< HEAD


=======
<<<<<<< HEAD
<<<<<<< HEAD


=======
=======
>>>>>>> 0ebf3c6f365df4e08ef9b35c3e86556482c8281e
    @NotNull
    @Size(min=3, max=49)
    private String name;
>>>>>>> 0ebf3c6f365df4e08ef9b35c3e86556482c8281e
>>>>>>> e68f6f5f273a59d08c301141edfeaab44c0081a2
    private String startDate;
    private String stopDate;
    private String description;
    @ManyToOne
    private User user;

<<<<<<< HEAD
//    private String userName;
    @NotNull
    private String name;
=======
<<<<<<< HEAD
<<<<<<< HEAD
    private String userName;
    @NotNull
    private String name;
=======
>>>>>>> 0ebf3c6f365df4e08ef9b35c3e86556482c8281e
=======
>>>>>>> 0ebf3c6f365df4e08ef9b35c3e86556482c8281e
>>>>>>> e68f6f5f273a59d08c301141edfeaab44c0081a2
    public Symptoms() {
    }



    public Symptoms(int id, String name, String name1, String startDate, String stopDate, String description, String userName) {
<<<<<<< HEAD
//        super(id, name);
        super();
=======
        super(id, name);
>>>>>>> e68f6f5f273a59d08c301141edfeaab44c0081a2
        this.name = name1;
        this.startDate = startDate;
        this.stopDate = stopDate;
        this.description = description;
<<<<<<< HEAD
//        this.userName = userName;
    }

//    @Override
=======
        this.userName = userName;
    }

<<<<<<< HEAD
<<<<<<< HEAD
    @Override
=======
>>>>>>> 0ebf3c6f365df4e08ef9b35c3e86556482c8281e
=======
>>>>>>> 0ebf3c6f365df4e08ef9b35c3e86556482c8281e
>>>>>>> e68f6f5f273a59d08c301141edfeaab44c0081a2
    public String getName() {
        return name;
    }

<<<<<<< HEAD
//    @Override
=======
<<<<<<< HEAD
<<<<<<< HEAD
    @Override
=======
>>>>>>> 0ebf3c6f365df4e08ef9b35c3e86556482c8281e
=======
>>>>>>> 0ebf3c6f365df4e08ef9b35c3e86556482c8281e
>>>>>>> e68f6f5f273a59d08c301141edfeaab44c0081a2
    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStopDate() {
        return stopDate;
    }

    public void setStopDate(String stopDate) {
        this.stopDate = stopDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
<<<<<<< HEAD
//
//    public String getUserName() {
//        return userName;
//    }

//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
}
=======
<<<<<<< HEAD
<<<<<<< HEAD

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
=======
>>>>>>> 0ebf3c6f365df4e08ef9b35c3e86556482c8281e
}
=======
}
>>>>>>> 0ebf3c6f365df4e08ef9b35c3e86556482c8281e
>>>>>>> e68f6f5f273a59d08c301141edfeaab44c0081a2

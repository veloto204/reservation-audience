create table if not exists dean
(
  teacherId int not null,
  constraint teacherId_UNIQUE
    unique (teacherId)
);

alter table dean
  add primary key (teacherId);

create table if not exists faculty
(
  facultyId           int auto_increment,
  name                varchar(45) not null,
  dean_Teacher_DeanId int         null,
  constraint FacultyId_UNIQUE
    unique (facultyId),
  constraint dean_Teacher_DeanId_UNIQUE
    unique (dean_Teacher_DeanId),
  constraint fk_faculty_Dean1
    foreign key (dean_Teacher_DeanId) references dean (teacherId)
);

create index fk_faculty_Dean1_idx
  on faculty (dean_Teacher_DeanId);

alter table faculty
  add primary key (facultyId);

create table if not exists department
(
  departmentId                        int auto_increment,
  name                                varchar(45) not null,
  faculty_FacultyId                   int         not null,
  head_Of_Department_Teacher_HeaderId int         null,
  constraint DepartmentId_UNIQUE
    unique (departmentId),
  constraint head_Of_Department_Teacher_HeaderId_UNIQUE
    unique (head_Of_Department_Teacher_HeaderId),
  constraint fk_Department_Faculty1
    foreign key (faculty_FacultyId) references faculty (facultyId)
);

create index fk_Department_Faculty1_idx
  on department (faculty_FacultyId);

create index fk_department_head_Of_Department1_idx
  on department (head_Of_Department_Teacher_HeaderId);

alter table department
  add primary key (departmentId);

create table if not exists audience
(
  audienceId       int auto_increment,
  audience_number  varchar(20) not null,
  number_of_places int         not null,
  facultyId        int         not null,
  departmentId     int         null,
  constraint idAudience_UNIQUE
    unique (audienceId),
  constraint fk_Audience_Department1
    foreign key (departmentId) references department (departmentId),
  constraint fk_Audience_Faculty1
    foreign key (facultyId) references faculty (facultyId)
);

create index fk_Audience_Department1_idx
  on audience (departmentId);

create index fk_Audience_Faculty1_idx
  on audience (facultyId);

alter table audience
  add primary key (audienceId);

create table if not exists groupcourse
(
  groupId      int auto_increment,
  courseS      int not null,
  studentGroup int null,
  constraint GroupId_UNIQUE
    unique (groupId)
);

alter table groupcourse
  add primary key (groupId);

create table if not exists lesson
(
  lessonId     int auto_increment
    primary key,
  numberLesson int  not null,
  startTime    time not null,
  finishTime   time null,
  facultyId    int  not null,
  constraint fk_lesson_faculty1
    foreign key (facultyId) references faculty (facultyId)
);

create index fk_lesson_faculty1_idx
  on lesson (facultyId);

create table if not exists parameteraudience
(
  parameterId    int auto_increment,
  parameter_type varchar(45) not null,
  constraint ParameterId_UNIQUE
    unique (parameterId)
);

alter table parameteraudience
  add primary key (parameterId);

create table if not exists audiencehasparameters
(
  parameterId int not null,
  audienceId  int not null,
  primary key (parameterId, audienceId),
  constraint fk_AudienceParametrs_Audience1
    foreign key (audienceId) references audience (audienceId),
  constraint `fk_AudienceParametrs_Parameter Audience1`
    foreign key (parameterId) references parameteraudience (parameterId)
);

create index fk_AudienceParametrs_Audience1_idx
  on audiencehasparameters (audienceId);

create table if not exists subject
(
  subjectId               int auto_increment,
  name                    varchar(25) not null,
  department_DepartmentId int         null,
  constraint idSubject_UNIQUE
    unique (subjectId),
  constraint fk_Subject_Department1
    foreign key (department_DepartmentId) references department (departmentId)
);

create index fk_Subject_Department1_idx
  on subject (department_DepartmentId);

alter table subject
  add primary key (subjectId);

create table if not exists grouphassubject
(
  subjectId int not null
    primary key,
  groupId   int null,
  constraint fk_StudentSubjects_Student1
    foreign key (groupId) references groupcourse (groupId),
  constraint fk_StudentSubjects_Subject1
    foreign key (subjectId) references subject (subjectId)
);

create index fk_StudentSubjects_Subject1_idx
  on grouphassubject (subjectId);

create table if not exists teacher
(
  teacherId               int auto_increment,
  name                    varchar(25) not null,
  position                varchar(25) null,
  department_DepartmentId int         null,
  login                   varchar(45) null,
  password                varchar(45) null,
  constraint idTeacher_UNIQUE
    unique (teacherId),
  constraint fk_Teacher_Department1
    foreign key (department_DepartmentId) references department (departmentId)
);

create index fk_Teacher_Department1_idx
  on teacher (department_DepartmentId);

alter table teacher
  add primary key (teacherId);

alter table dean
  add constraint fk_Dean_Teacher1
    foreign key (teacherId) references teacher (teacherId);

create table if not exists head_of_department
(
  teacherId int not null,
  constraint Teacher_HeaderId_UNIQUE
    unique (teacherId),
  constraint `fk_Head Of Department_Teacher1`
    foreign key (teacherId) references teacher (teacherId)
);

create index `fk_Head Of Department_Teacher1_idx`
  on head_of_department (teacherId);

alter table head_of_department
  add primary key (teacherId);

alter table department
  add constraint fk_department_head_Of_Department1
    foreign key (head_Of_Department_Teacher_HeaderId) references head_of_department (teacherId);

create table if not exists teacherhassubject
(
  teaSubId  int auto_increment,
  subjectId int null,
  teacherId int not null,
  constraint teaSubId_UNIQUE
    unique (teaSubId),
  constraint fk_Subject_has_Teacher_Subject1
    foreign key (subjectId) references subject (subjectId),
  constraint fk_Subject_has_Teacher_Teacher1
    foreign key (teacherId) references teacher (teacherId)
);

create index fk_Subject_has_Teacher_Subject1_idx
  on teacherhassubject (subjectId);

create index fk_Subject_has_Teacher_Teacher1_idx
  on teacherhassubject (teacherId);

alter table teacherhassubject
  add primary key (teaSubId);

create table if not exists booking
(
  bookingId  int auto_increment,
  audienceId int         not null,
  teaSubId   int         not null,
  date       date        not null,
  log        varchar(45) null,
  lessonId   int         not null,
  constraint idBooking_UNIQUE
    unique (bookingId),
  constraint fk_Booking_Audience1
    foreign key (audienceId) references audience (audienceId),
  constraint fk_booking_lesson1
    foreign key (lessonId) references lesson (lessonId),
  constraint fk_booking_teacherHasSubject1
    foreign key (teaSubId) references teacherhassubject (teaSubId)
);

create index fk_Booking_Audience1_idx
  on booking (audienceId);

create index fk_booking_lesson1_idx
  on booking (lessonId);

create index fk_booking_teacherHasSubject1_idx
  on booking (teaSubId);

alter table booking
  add primary key (bookingId);

create table if not exists grouphasbooking
(
  groupId   int not null,
  bookingId int not null,
  primary key (groupId, bookingId),
  constraint fk_Group_has_Booking_Booking1
    foreign key (bookingId) references booking (bookingId),
  constraint fk_Group_has_Booking_Group1
    foreign key (groupId) references groupcourse (groupId)
);

create index fk_Group_has_Booking_Booking1_idx
  on grouphasbooking (bookingId);

create index fk_Group_has_Booking_Group1_idx
  on grouphasbooking (groupId);
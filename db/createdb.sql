/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/1/7 13:58:07                            */
/*==============================================================*/


drop table if exists Account;

drop table if exists Admin;

drop table if exists Customer;

drop table if exists ExFlight;

drop table if exists ExFlightProduct;

drop table if exists FFP;

drop table if exists Flight;

drop table if exists FlightProduct;

drop table if exists FlightState;

drop table if exists FoodType;

drop table if exists Member;

drop table if exists OrderList;

drop table if exists RuleList;

drop table if exists Statement;

drop table if exists Ticket;

/*==============================================================*/
/* Table: Account                                               */
/*==============================================================*/
create table Account
(
   account              varchar(20) not null,
   `password`             varchar(20) not null,
   `right`                bool not null,
   primary key (account)
);

/*==============================================================*/
/* Table: Admin                                                 */
/*==============================================================*/
create table Admin
(
   account              varchar(20) not null,
   `password`             varchar(20) not null,
   `right`                bool not null,
   adminName            varchar(20) not null,
   adminIDCard          varchar(20) not null,
   primary key (account)
);


/*==============================================================*/
/* Table: Customer                                              */
/*==============================================================*/
create table Customer
(
   account              varchar(20) not null,
   memberID             int not null,
   `password`             varchar(20) not null,
   `right`                bool not null,
   userName             varchar(20) not null,
   birthdate            date not null,
   userIDCard           varchar(20) not null,
   userTel              varchar(20) not null,
   email                varchar(50) not null,
   point                int not null,
   userSex              bool not null,
   primary key (account)
);

/*==============================================================*/
/* Table: ExFlight                                              */
/*==============================================================*/
create table ExFlight
(
   flightID             varchar(20) not null,
   exFlightDate         date not null,
   flightStateID        int,
   foodTypeID           int,
   totalTime            varchar(20) not null,
   departTime           time,
   arriveTime           time,
   onRevise             bool not null,
   onRefund             bool not null,
   primary key (flightID, exFlightDate)
);

/*==============================================================*/
/* Table: ExFlightProduct                                       */
/*==============================================================*/
create table ExFlightProduct
(
   flightID             varchar(20) not null,
   exFlightDate         date not null,
   flightProductID      varchar(2) not null,
   price                int not null,
   pointPrice           int not null,
   leftTicketNum        int not null,
   onSale               bool not null,
   primary key (flightID, exFlightDate, flightProductID)
);


/*==============================================================*/
/* Table: FFP                                                   */
/*==============================================================*/
create table FFP
(
   flightProductID      varchar(2) not null,
   flightID             varchar(20) not null,
   seatNum              int not null,
   prePrice             int not null,
   prePointPrice        int not null,
   rewardPoint          int not null,
   primary key (flightProductID, flightID)
);

/*==============================================================*/
/* Table: Flight                                                */
/*==============================================================*/
create table Flight
(
   flightID             varchar(20) not null,
   preDepartTime        time not null,
   preTotalTime         varchar(20) not null,
   flightType           varchar(20) not null,
   totalSeatNum         int not null,
   departCity           varchar(20) not null,
   arriveCity           varchar(20) not null,
   insurancePrice       int not null,
   primary key (flightID)
);

/*==============================================================*/
/* Table: FlightProduct                                         */
/*==============================================================*/
create table FlightProduct
(
   flightProductID      varchar(2) not null,
   flightProductName    varchar(20) not null,
   primary key (flightProductID)
);

/*==============================================================*/
/* Table: FlightState                                           */
/*==============================================================*/
create table FlightState
(
   flightStateID        int not null,
   flightStateContext   varchar(20) not null,
   primary key (flightStateID)
);

/*==============================================================*/
/* Table: FoodType                                              */
/*==============================================================*/
create table FoodType
(
   foodTypeID           int not null,
   foodName             varchar(20) not null,
   primary key (foodTypeID)
);

/*==============================================================*/
/* Table: Member                                                */
/*==============================================================*/
create table Member
(
   memberID             int not null,
   memberName           varchar(20) not null,
   primary key (memberID)
);

/*==============================================================*/
/* Table: OrderList                                             */
/*==============================================================*/
create table OrderList
(
   account              varchar(20) not null,
   orderID              int not null,
   orderTime            datetime not null,
   primary key (account, orderID)
);

/*==============================================================*/
/* Table: RuleList                                              */
/*==============================================================*/
create table RuleList
(
   ruleID               int not null,
   ruleContext          text not null,
   reviseTime           datetime not null,
   primary key (ruleID)
);

/*==============================================================*/
/* Table: Statement                                             */
/*==============================================================*/
create table Statement
(
   flightID             varchar(20) not null,
   year                 int not null,
   month                int not null,
   ticketNum            int not null,
   income               int not null,
   rate                 float not null,
   exNum                int not null,
   primary key (flightID, year, month)
);

/*==============================================================*/
/* Table: Ticket                                                */
/*==============================================================*/
create table Ticket
(
   account              varchar(20) not null,
   orderID              int not null,
   ticketID             varchar(20) not null,
   flightID             varchar(20) not null,
   exFlightDate         date not null,
   flightProductID      varchar(2) not null,
   passengerName        varchar(20) not null,
   passengerTel         varchar(20) not null,
   passengerIDCard      varchar(20) not null,
   insurance            bool not null,
   payment              bool not null,
   ticketPrice          int not null,
   passengerSex         bool not null,
   primary key (account, orderID, ticketID)
);

alter table Admin add constraint FK_继承2 foreign key (account)
      references Account (account);

alter table Customer add constraint FK_属于 foreign key (memberID)
      references Member (memberID);

alter table Customer add constraint FK_继承 foreign key (account)
      references Account (account);

alter table ExFlight add constraint FK_提供 foreign key (foodTypeID)
      references FoodType (foodTypeID);

alter table ExFlight add constraint FK_航班状态 foreign key (flightStateID)
      references FlightState (flightStateID);

alter table ExFlight add constraint FK_该日航班 foreign key (flightID)
      references Flight (flightID);

alter table ExFlightProduct add constraint FK_具有_1 foreign key (flightID, exFlightDate)
      references ExFlight (flightID, exFlightDate);

alter table ExFlightProduct add constraint FK_该日舱位 foreign key (flightProductID)
      references FlightProduct (flightProductID);

alter table FFP add constraint FK_FFP foreign key (flightProductID)
      references FlightProduct (flightProductID);

alter table FFP add constraint FK_FFP2 foreign key (flightID)
      references Flight (flightID);

alter table OrderList add constraint FK_查询 foreign key (account)
      references Customer (account);

alter table Statement add constraint FK_该月报表 foreign key (flightID)
      references Flight (flightID);

alter table Ticket add constraint FK_舱位机票 foreign key (flightID, exFlightDate, flightProductID)
      references ExFlightProduct (flightID, exFlightDate, flightProductID);

alter table Ticket add constraint FK_订单项目详情 foreign key (account, orderID)
      references OrderList (account, orderID);
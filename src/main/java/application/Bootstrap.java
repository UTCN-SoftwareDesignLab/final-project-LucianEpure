package application;

import dto.UserDto;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.ActivityRepository;
import repository.RoleRepository;
import service.regiment.RegimentService;
import service.schedule.ScheduleService;
import service.regiment.UserService;

import javax.annotation.PostConstruct;


import static application.Constants.*;


@Component
public class Bootstrap {
    private RoleRepository roleRepository;

    private RegimentService regimentService;
    private UserService userService;
    private ActivityRepository activityRepository;
    private ScheduleService scheduleService;


    @Autowired
    public Bootstrap(RoleRepository roleRepository, UserService userService, RegimentService regimentService, ActivityRepository activityRepository, ScheduleService scheduleService ){
        this.roleRepository = roleRepository;
        this.regimentService = regimentService;
        this.activityRepository = activityRepository;
        this.userService = userService;
        this.scheduleService = scheduleService;

    }

    @PostConstruct
    private void initialize(){
        initRoles();
        initTypes();
        initActivities();
        initUsers();

    }

    private void initRoles() {
        Role quartermaster = new Role(Constants.QUARTERMASTER);
        Role regimentCommander = new Role(Constants.REGIMENTCOMMANDER);
        roleRepository.save(quartermaster);
        roleRepository.save(regimentCommander);
    }

    private void initTypes(){

        regimentService.addNewType(INFANTRY);
        regimentService.addNewType(MEDICS);
        regimentService.addNewType(ASSAULT);
        regimentService.addNewType(ENGINEERS);
        regimentService.addNewType(RECRUITS);
    }

    private void initActivities(){

        Setup setup = new Setup();
        Activity eating = new Activity(EATING);
        Activity sleeping = new Activity(SLEEPING);
        Activity medTraining = new Activity(MEDTRAINING);
        Activity shootTraining = new Activity(SHOOTTRAINING);
        Activity strengthTraining = new Activity(STRENGTHTRAINING);
        Activity tacticsTraining = new Activity(TACTICSTRAINING);

        activityRepository.save(setup.setupActivity(eating,2,20,5,0,0,0,50,0,0));
        activityRepository.save(setup.setupActivity(sleeping,8,60,5,0,2,0,0,0,0));
        activityRepository.save(setup.setupActivity(medTraining,2,-15,0,0,5,20,0,0,35));
        activityRepository.save(setup.setupActivity(shootTraining,2,-15,10,30,0,0,0,100,10));
        activityRepository.save(setup.setupActivity(strengthTraining,3,-40,40,0,0,0,0,0,10));
        activityRepository.save(setup.setupActivity(tacticsTraining,2,-10,0,0,20,0,0,0,5));


    }

    private void initUsers(){
        UserDto user1 = new UserDto();
        user1.setUsername("QM1@yahoo.com");
        user1.setPassword("aB123456!");
        userService.registerAdmin(user1);
        regimentService.enlistRegiment(123456,"aB123456!");
        //ScheduleDto scheduleDto = new ScheduleDto();

       // scheduleDto.setDate(new Date());
       // scheduleService.save(scheduleDto, 123456);

    }

}



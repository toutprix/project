package com.demo.jwtauthentication.security.services;

import com.demo.jwtauthentication.model.Case;
import com.demo.jwtauthentication.model.User;
import com.demo.jwtauthentication.repository.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Implementation of {@link CaseService} interface
 *
 * @author Artem P.
 * @version 1.0
 */

@Service
public class CaseService {

    @Autowired
    private CaseRepository caseDao;

    private Calendar currentDate;

    //Today
    public List<Case> findForToday(User user) {
        return findCasesByTomorrows(0,user);
    }

    //Tomorrow
    public List<Case> findForTomorrow(User user) {
        return findCasesByTomorrows(1,user);
    }

    //Day after tomorrow
    public List<Case> findForDayAfterTomorrow(User user) {
        return findCasesByTomorrows(2,user);
    }

    //After day after tomorrow
    public List<Case> findForAfterDayAfterTomorrow(User user) {
        return findCasesByTomorrows(3,user);
    }

    //Week
    public List<Case> findForWeek(User user) {
        return findCasesByTomorrows(7,user);
    }

    //Month
    public List<Case> findForMonth(User user) {
        List<Case> cases = caseDao.findAllByUserId(user);

        List<Case> result = new ArrayList<>();

        currentDate = getDate();

        Calendar afterDate = GregorianCalendar.getInstance();
        afterDate.setTime(currentDate.getTime());
        currentDate.add(Calendar.DAY_OF_WEEK, - 1);
        afterDate.add(Calendar.MONTH,1);
        afterDate.set(Calendar.HOUR_OF_DAY,23);
        afterDate.set(Calendar.MINUTE,59);
        afterDate.set(Calendar.SECOND,59);

        for(Case x : cases)
            if(currentDate.getTime().getTime() <= x.getDate().getTime()
                    && x.getDate().getTime() <= afterDate.getTime().getTime())
                result.add(x);
        return result;
    }

    private List<Case> findCasesByTomorrows(int day, User user){
        return getCases(day, user, Calendar.DAY_OF_WEEK);
    }

    private Calendar getDate(){
        currentDate = GregorianCalendar.getInstance();
        currentDate.setTimeInMillis(System.currentTimeMillis());
        currentDate.set(Calendar.HOUR, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        return currentDate;
    }

    private List<Case> getCases(int day, User user, int dayOfWeek) {
        List<Case> cases = caseDao.findAllByUserId(user);

        List<Case> result = new ArrayList<>();

        currentDate = getDate();

        Calendar afterDate = GregorianCalendar.getInstance();
        afterDate.setTime(currentDate.getTime());

        currentDate.add(dayOfWeek, day - 1);
        afterDate.add(dayOfWeek,day);
        afterDate.set(Calendar.HOUR_OF_DAY,23);
        afterDate.set(Calendar.MINUTE,59);
        afterDate.set(Calendar.SECOND,59);

        for(Case x : cases)
            if(currentDate.getTime().getTime() <= x.getDate().getTime()
                    && x.getDate().getTime() <= afterDate.getTime().getTime())
                result.add(x);
        return result;
    }
}

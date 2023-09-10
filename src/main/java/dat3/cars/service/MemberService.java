package dat3.cars.service;

import dat3.cars.dto.MemberRequest;
import dat3.cars.dto.MemberResponse;
import dat3.cars.dto.ReservationResponse;
import dat3.cars.entity.Member;
import dat3.cars.entity.Reservation;
import dat3.cars.repository.MemberRepository;
import dat3.cars.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    MemberRepository memberRepository;
    ReservationRepository reservationRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

//    public List<MemberResponse> getMembers(boolean includeAll) {
//        List<Member> members = memberRepository.findAll();
//        List<MemberResponse> response = members.stream().map(member -> new MemberResponse(member, includeAll)).toList();
//        for(MemberResponse memberResponse: response) {
//            List<Reservation> reservations = reservationRepository.findReservationByMember_Username(memberResponse.getUsername());
//        }
//        return response;
//    }

        public List<MemberResponse> getMembers(boolean includeAll) {
            List<Member> members = memberRepository.findAll();
            List<MemberResponse> response = new ArrayList<>();

            for (Member member : members) {
                MemberResponse memberResponse = convertToMemberResponse(member);
                if (includeAll) {
                    List<Reservation> reservations = reservationRepository.findReservationByMember_Username(member.getUsername());
                    List<ReservationResponse> reservationResponses = new ArrayList<>();
                    for (Reservation reservation : reservations) {
                        reservationResponses.add(new ReservationResponse(reservation));
                    }
                    memberResponse.setReservations(reservationResponses);
                }
                response.add(memberResponse);
            }

            return response;
        }

        private MemberResponse convertToMemberResponse(Member member) {
            MemberResponse memberResponse = new MemberResponse(member, true); // assuming your current constructor
            List<ReservationResponse> reservationResponses = new ArrayList<>();

            for (Reservation reservation : member.getReservations()) {
                reservationResponses.add(new ReservationResponse(reservation));
            }

            memberResponse.setReservations(reservationResponses);
            return memberResponse;
        }




    public MemberResponse addMember(MemberRequest body) {
        if(memberRepository.existsById(body.getUsername())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"This user already exists");
        }

        Member newMember = MemberRequest.getMemberEntity(body);

        newMember = memberRepository.save(newMember);
        return new MemberResponse(newMember, true);
    }

    public ResponseEntity<Boolean> editMember(MemberRequest body, String username) {
        Member member = getMemberByUsername(username);
        if(!body.getUsername().equals(username)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cannot change username");
        }
        member.setPassword(body.getPassword());
        member.setEmail(body.getEmail());
        member.setFirstName(body.getFirstName());
        member.setLastName(body.getLastName());
        member.setStreet(body.getStreet());
        member.setCity(body.getCity());
        member.setZip(body.getZip());
        memberRepository.save(member);
        return ResponseEntity.ok(true);
    }

    public MemberResponse findById(String username) {
        Member member = getMemberByUsername(username);
        return new MemberResponse(member, true);
    }


    /*public ResponseEntity<Boolean> deleteMember(String username ) {
        if(!memberRepository.existsById(username)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Member with this username does not exist");
        }
        memberRepository.deleteById(username);
        return ResponseEntity.ok(true);
    }*/

    public void setRankingForUser(String username, int value) {
        Member member = getMemberByUsername(username);
        member.setRanking(value);
        memberRepository.save(member);
    }


    public void deleteMemberByUsername(String username) {
        Member member = getMemberByUsername(username);
        memberRepository.delete(member);
    }


    private Member getMemberByUsername(String username) {
        return memberRepository.findById(username).
                orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Member with this username does not exist"));
    }



}
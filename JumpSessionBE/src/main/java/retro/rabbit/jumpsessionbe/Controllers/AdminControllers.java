package retro.rabbit.jumpsessionbe.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import retro.rabbit.jumpsessionbe.Models.Admin;
import retro.rabbit.jumpsessionbe.Services.AdminService;

import retro.rabbit.jumpsessionbe.Models.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/admin", consumes = "application/json", produces = "application/json")
public class AdminControllers {

        @Autowired
        private AdminService adminService;

        @GetMapping("/get-admins")
        public List<Admin> getAllAdmins() {
            return adminService.getAllAdmins();
        }

        @GetMapping("/get-admin/{id}")
        public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
            return adminService.getAdminById(id)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PostMapping("/create-admin")
        public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
            return ResponseEntity.ok(adminService.createAdmin(admin));
        }

        @DeleteMapping("/delete-admin/{id}")
        public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
            adminService.deleteAdmin(id);
            return ResponseEntity.noContent().build();
        }

        // Add to join table
        @PutMapping("/add-checkout/")
        public ResponseEntity<UserBooks> checkOutBook(@RequestBody UserBooks newEntry) {
            try {
//                UserBooks thingy = adminService.addCheckOut(newEntry);
                return ResponseEntity.ok(adminService.addCheckOut(newEntry));
            }
            catch ( Exception exception ) {
                return ResponseEntity.badRequest().body(new UserBooks());
            }
        }
    }


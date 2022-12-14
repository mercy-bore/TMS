 <!-- Sidebar Start -->
        <div class="sidebar pe-4 pb-3">
            <nav class="navbar bg-light navbar-light">
                <a href="home.jsp" class="navbar-brand mx-4 mb-3">
                    <h3 class="text-primary">Transport </h3>
                    <h3 class="text-primary">Management</h3>
                    <h3 class="text-primary">System</h3>

                </a>
                <div class="d-flex align-items-center ms-4 mb-4">
                    <div class="position-relative">
                        <img class="rounded-circle" src="img/user.png" alt="" style="width: 40px; height: 40px;">
                        <div class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
                    </div>
                    <div class="ms-3">
                        <h6 class="mb-0"> <%= session.getAttribute("username") %></h6>
                    </div>
                </div>
                <div class="navbar-nav w-100">
                    <a href="home.jsp" class="nav-item nav-link"><i class="fa fa-tachometer-alt me-2"></i>Home</a>
                      <div class="nav-item dropdown">
                                            <a href="clients.jsp" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="far fa-file-alt me-2"></i>Client Pages</a>
                                            <div class="dropdown-menu bg-transparent border-0">
                                                <a href="clients.jsp" class="dropdown-item">View Clients</a>
                                            </div>
                                        </div>
                    <div class="nav-item dropdown">
                        <a href="vehicles.jsp" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="far fa-file-alt me-2"></i>Vehicle pages</a>
                        <div class="dropdown-menu bg-transparent border-0">
                            <a href="vehicles.jsp" class="dropdown-item">View Vehicles</a>
                             <a href="vehicleswithorders.jsp" class="dropdown-item">View Vehicles with Orders</a>
                              <a href="vehicleswithoutorders.jsp" class="dropdown-item">View Vehicles without Orders</a>

                        </div>
                    </div>
                   <div class="nav-item dropdown">
                                           <a href="drivers.jsp" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="far fa-file-alt me-2"></i>Driver pages</a>
                                           <div class="dropdown-menu bg-transparent border-0">
                                            <a href="drivers.jsp" class="dropdown-item">View Drivers</a>
                                            <a href="driverwithorder.jsp" class="dropdown-item">View Drivers with Orders</a>
                                            <a href="driverswithoutorder.jsp" class="dropdown-item">View Drivers without Orders</a>

                                             </div>
                                      </div>
                    <div class="nav-item dropdown">
                        <a href="orders.jsp" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="far fa-file-alt me-2"></i>Order pages</a>
                        <div class="dropdown-menu bg-transparent border-0">
                            <a href="orders.jsp" class="dropdown-item">View Orders</a>
                            <a href="activeorders.jsp" class="dropdown-item">View Active Orders</a>
                            <a href="deliveredorders.jsp" class="dropdown-item">View Delivered Orders</a>

                        </div>
                    </div>

                    <a href="sendemail.jsp" class="nav-item nav-link"><i class="fa fa-table me-2"></i>Send Email</a>
                    <a href="./logout" class="nav-item nav-link"><i class="fa fa-table me-2"></i>Logout</a>

                </div>
            </nav>
        </div>
        <!-- Sidebar End -->
